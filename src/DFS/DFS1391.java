package DFS;

import java.util.ArrayList;
import java.util.List;

public class DFS1391 {
    /*
    检查网格中是否存在有效路径
     */

    int m, n;
    int[][] grid;
    boolean[][] visited;

    public boolean hasValidPath(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.grid = grid;
        this.visited = new boolean[m][n];
        dfs(0, 0);
        return visited[m - 1][n - 1];
    }

    public void dfs(int row, int col) {
        if (visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        List<int[]> reachableCells = getReachableCells(row, col);
        for (int[] nextCell : reachableCells) {
            dfs(nextCell[0], nextCell[1]);
        }
    }

    public List<int[]> getReachableCells(int row, int col) {
        List<int[]> reachableCells = new ArrayList<int[]>();
        if (row > 0) {
            if ((grid[row][col] == 2 || grid[row][col] == 5 || grid[row][col] == 6) && (grid[row - 1][col] == 2 || grid[row - 1][col] == 3 || grid[row - 1][col] == 4)) {
                reachableCells.add(new int[]{row - 1, col});
            }
        }
        if (row < m - 1) {
            if ((grid[row][col] == 2 || grid[row][col] == 3 || grid[row][col] == 4) && (grid[row + 1][col] == 2 || grid[row + 1][col] == 5 || grid[row + 1][col] == 6)) {
                reachableCells.add(new int[]{row + 1, col});
            }
        }
        if (col > 0) {
            if ((grid[row][col] == 1 || grid[row][col] == 3 || grid[row][col] == 5) && (grid[row][col - 1] == 1 || grid[row][col - 1] == 4 || grid[row][col - 1] == 6)) {
                reachableCells.add(new int[]{row, col - 1});
            }
        }
        if (col < n - 1) {
            if ((grid[row][col] == 1 || grid[row][col] == 4 || grid[row][col] == 6) && (grid[row][col + 1] == 1 || grid[row][col + 1] == 3 || grid[row][col + 1] == 5)) {
                reachableCells.add(new int[]{row, col + 1});
            }
        }
        return reachableCells;
    }
}
