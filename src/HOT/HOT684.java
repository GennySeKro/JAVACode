package HOT;

public class HOT684 {
    /*
    冗余链接
     */

    public int[] findRedundantConnection(int[][] edges){
        int len = edges.length;
        UnionFind unionFind = new UnionFind(len + 1);
        for (int i = 0;i < len;i++){
            if (unionFind.connected(edges[i][0], edges[i][1])){
                return new int[]{edges[i][0], edges[i][1]};
            }else {
                unionFind.union(edges[i][0], edges[i][1]);
            }
        }
        return new int[0];
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
            if (rootA == rootB){
                return;
            }else {
                father[rootA] = rootB;
            }
        }

        public int find(int value){
            while (father[value] != value){
                father[value] = father[father[value]];
                value = father[value];
            }
            return father[value];
        }

        public boolean connected(int a, int b){
            return find(a) == find(b);
        }
    }
}
