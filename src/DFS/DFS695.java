package DFS;

public class DFS695 {
    /*
    岛屿的最大面积
     */

    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        Boolean[][] used = new Boolean[grid.length][grid[0].length];

        for (int i = 0;i < grid.length;i++){
            for (int j = 0;j < grid[0].length;j++){
                if (grid[i][j] == 1){
                    res = Math.max(res, calculateArea(grid, used, i, j, 0));
                }
            }
        }

        return res;
    }

    private int calculateArea(int[][] grid, Boolean[][] used, int i, int j, int area) {
        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1 || grid[i][j] == 0 || used[i][j] == Boolean.TRUE){
            return 0;
        }

        used[i][j] = Boolean.TRUE;
        return calculateArea(grid, used, i - 1, j, area) + calculateArea(grid, used, i, j + 1, area) +
                calculateArea(grid, used, i + 1, j, area) + calculateArea(grid, used, i, j - 1, area) + 1;
    }
}
