package HOT;

import java.util.ArrayList;

public class HOT685 {
    /*
    冗余连接Ⅱ
     */

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int len = edges.length;
        int[] inDegree = new int[len + 1];
        for(int i = 0; i < edges.length; i++)
        {
            // 入度
            inDegree[edges[i][1]] += 1;
        }

        // 找入度为2的节点所对应的边，注意要倒序，因为优先返回最后出现在二维数组中的答案
        ArrayList<Integer> twoDegree = new ArrayList<Integer>();
        for(int i = edges.length - 1; i >= 0; i--)
        {
            if(inDegree[edges[i][1]] == 2) {
                twoDegree.add(i);
            }
        }
        // 如果有入度为2的节点，那么一定是两条边里删一个，看删哪个可以构成树
        if(!twoDegree.isEmpty())
        {
            if(isTreeAfterRemoveEdge(edges, twoDegree.get(0))) {
                return edges[twoDegree.get(0)];
            }
            return edges[twoDegree.get(1)];
        }
        // 明确没有入度为2的情况，那么一定有有向环，找到构成环的边返回就可以了
        return getRemoveEdge(edges);
    }

    private Boolean isTreeAfterRemoveEdge(int[][] edges, int deleteEdge)
    {
        UnionFind unionFind = new UnionFind(edges.length + 1);
        for(int i = 0; i < edges.length; i++)
        {
            if(i == deleteEdge) continue;
            if(unionFind.connected(edges[i][0], edges[i][1])) { // 构成有向环了，一定不是树
                return false;
            }
            unionFind.union(edges[i][0], edges[i][1]);
        }
        return true;
    }

    private int[] getRemoveEdge(int[][] edges) {
        UnionFind unionFind = new UnionFind(edges.length + 1);
        for(int i = 0; i < edges.length; i++) {
            if(unionFind.connected(edges[i][0], edges[i][1])) { // 构成有向环了，就是要删除的边
                return edges[i];
            }
            unionFind.union(edges[i][0], edges[i][1]);
        }
        return null;
    }

    class UnionFind{
        private int[] father;

        public UnionFind(int n){
            father = new int[n];
            for (int i = 0;i < n;i++){
                father[i] = i;
            }
        }

        public void union(int a, int b){
            int rootA = find(a);
            int rootB = find(b);
            if (rootA != rootB){
                father[rootA] = rootB;
            }
        }

        public int find(int value){
            if (value == father[value]){
                return value;
            }else {
                return find(father[value]);
            }

        }

        public boolean connected(int a, int b){
            return find(a) == find(b);
        }
    }
}
