package HOT;

import org.junit.Test;

public class HOT1020 {
    /*
    飞地的数量
    先处理四个边界，再判断数量
     */

    int area = 0;
    public int numEnclaves(int[][] grid) {
        int res = 0;
        for (int i = 0;i < grid[0].length;i++){
            dfs(grid, 0, i, true);
        }
        for (int i = 0;i < grid[0].length;i++){
            dfs(grid, grid.length - 1, i, true);
        }
        for (int i = 0;i < grid.length;i++){
            dfs(grid, i, 0, true);
        }
        for (int i = 0;i < grid.length;i++){
            dfs(grid, i, grid[0].length - 1, true);
        }

        for (int i = 0;i < grid.length;i++){
            for (int j = 0;j < grid[0].length;j++){
                if (grid[i][j] == 1){
                    dfs(grid, i, j, false);
                }
            }
        }
        return area;
    }

    private void dfs(int[][] grid, int i, int j, boolean flag) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0){
            return;
        }
        grid[i][j] = 0;
        if (!flag){
            area++;
        }
        dfs(grid, i - 1, j, flag);
        dfs(grid, i, j + 1, flag);
        dfs(grid, i + 1, j, flag);
        dfs(grid, i, j - 1, flag);
    }


    @Test
    public void test(){
        int[][] grid = new int[][]{
                {0,0,0,1,1,1,0,1,0,0},
                {1,1,0,0,0,1,0,1,1,1},
                {0,0,0,1,1,1,0,1,0,0},
                {0,1,1,0,0,0,1,0,1,0},
                {0,1,1,1,1,1,0,0,1,0},
                {0,0,1,0,1,1,1,1,0,1},
                {0,1,1,0,0,0,1,1,1,1},
                {0,0,1,0,0,1,0,1,0,1},
                {1,0,1,0,1,1,0,0,0,0},
                {0,0,0,0,1,1,0,0,0,1}
        };
        System.out.println(numEnclaves(grid));
    }
}
