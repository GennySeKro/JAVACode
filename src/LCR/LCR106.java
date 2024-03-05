package LCR;

public class LCR106 {
    /*
    判断二分图
     */

    public boolean isBipartite(int[][] graph) {
        unionFind unionFind = new unionFind(graph.length);
        for (int i = 0;i < graph.length;i++){
            for (int j = 1;j < graph[i].length;j++){
                unionFind.union(graph[i][0], graph[i][j]);
            }
        }

        for (int i = 0;i < graph.length;i++){
            for (int j = 0;j < graph[i].length;j++){
                if (unionFind.find(i) == unionFind.find(graph[i][j])){
                    return false;
                }
            }
        }
        return true;
    }

    static class unionFind{

        int[] parent;

        unionFind(int n){
            parent = new int[n];
            for (int i = 0;i < n;i++){
                parent[i] = i;
            }
        }

        public int find(int value){
            if (parent[value] == value){
                return value;
            }else {
                parent[value] = find(parent[value]);
            }
            return parent[value];
        }

        public void union(int parent, int child){
            this.parent[child] = find(parent);
        }
    }
}
