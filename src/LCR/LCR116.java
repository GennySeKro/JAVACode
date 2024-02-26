package LCR;

import org.junit.Test;

public class LCR116 {
    /*
    省份的数量
     */

    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int res = 0;
        for (int i = 0;i < isConnected.length;i++){
            if (!visited[i]){
                dfs(isConnected, visited, i);
                res++;
            }
        }
        return res;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int i) {
        for (int j = 0;j < isConnected.length;j++){
            if (isConnected[i][j] == 1 && !visited[j]){
                visited[j] = true;
                dfs(isConnected, visited, j);
            }
        }
    }

    @Test
    public void test(){
        System.out.println(findCircleNum(new int[][]{{1,1,0},{1,1,0},{0,0,1}}));
    }
}
