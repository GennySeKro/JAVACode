package LCR;

public class LCR105 {
    /*
    岛屿的最大面积
     */

    int res = 0;
    public int maxAreaOfIsland(int[][] grid) {
        for (int i = 0;i < grid.length;i++){
            for (int j = 0;j < grid[0].length;j++){
                if (grid[i][j] == 1){
                    res = Math.max(res, dfs(grid, i, j));
                }
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0){
            return 0;
        }
        grid[i][j] = 0;
        return 1 + dfs(grid,i - 1,j) + dfs(grid,i + 1,j) + dfs(grid,i,j + 1) + dfs(grid,i,j - 1);
    }
}
