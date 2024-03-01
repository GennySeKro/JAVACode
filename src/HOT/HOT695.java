package HOT;

import org.junit.Test;

public class HOT695 {
    /*
    岛屿的最大面积
     */

    int area = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0;i < grid.length;i++){
            for(int j = 0;j < grid[0].length;j++){
                if (grid[i][j] == 1){
                    dfs(grid, i, j);
                    res = Math.max(res, area);
                    area = 0;
                }
            }
        }
        return res;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0){
            return ;
        }
        grid[i][j] = 0;
        area = area + 1;
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
    }

    @Test
    public void test(){
        int[][] grid = new int[][]{{1,0},{0,0}};
        System.out.println(maxAreaOfIsland(grid));
    }
}
