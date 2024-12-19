package HOT100;

public class HOT200 {
    /*
    岛屿数量
     */
    private int[][] direction = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0;i < grid.length;i++){
            for (int j = 0;j < grid[0].length;j++){
                if (grid[i][j] == '1'){
                    dfs(grid, i, j);
                    res++;
                }
            }
        }

        return res;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0'){
            return;
        }

        grid[i][j] = '0';
        dfs(grid, i + direction[0][0], j + direction[0][1]);
        dfs(grid, i + direction[1][0], j + direction[1][1]);
        dfs(grid, i + direction[2][0], j + direction[2][1]);
        dfs(grid, i + direction[3][0], j + direction[3][1]);

    }

}
