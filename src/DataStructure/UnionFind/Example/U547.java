package DataStructure.UnionFind.Example;

import DataStructure.UnionFind.DSU;
import org.junit.Test;

public class U547 {
    /*
    省份数量
     */

    public int findCircleNum(int[][] isConnected) {
        DSU dsu = new DSU(isConnected.length);

        for (int i = 0; i < isConnected.length; i++){
            for (int j = i + 1; j < isConnected.length; j++){
                if (isConnected[i][j] == 1){
                    dsu.union(i, j);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < isConnected.length; i++){
            if (dsu.parents[i] == i){
                res++;
            }
        }
        return res;
    }


    static class DSU{
        int parents[];

        public DSU(int n){
            parents = new int[n];
            for (int i = 0; i < n; i++){
                parents[i] = i;
            }
        }

        private int find(int x){
            if (parents[x] != x){
                parents[x] = find(parents[x]);
            }

            return parents[x];
        }

        private void union(int x, int y){
            parents[find(x)] = find(y);
        }

    }

    @Test
    public void test(){
        System.out.println(findCircleNum(new int[][]{{1,1,0},{1,1,0},{0,0,1}}));
    }
}
