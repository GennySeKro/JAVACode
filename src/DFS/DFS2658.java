package DFS;

public class DFS2658 {
    /*
    网格图中鱼的最大数目
     */

    public int findMaxFish(int[][] grid) {
        int res = 0;
        for (int i = 0;i < grid.length;i++){
            for (int j = 0;j < grid[0].length;j++){
                if (grid[i][j] != 0){
                    res = Math.max(res, DFS(grid, i, j));
                }
            }
        }

        return res;
    }

    private int DFS(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length -1 || grid[i][j] == 0){
            return 0;
        }

        int value = grid[i][j];
        grid[i][j] = 1;

        return DFS(grid, i - 1, j) + DFS(grid, i, j + 1) +
                DFS(grid, i + 1, j) + DFS(grid, i, j - 1) + value;
    }
}
