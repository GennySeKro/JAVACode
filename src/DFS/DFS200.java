package DFS;

public class DFS200 {
    /*
    岛屿数量
     */

    public int numIslands(char[][] grid) {
        int res = 0;
        Boolean[][] used = new Boolean[grid.length][grid[0].length];
        for (int i = 0;i < grid.length;i++){
            for (int j = 0;j < grid[0].length;j++){
                if (grid[i][j] == '1'){
                    res++;
                    DFS(grid, i, j, used);
                }
            }
        }

        return res;
    }

    private void DFS(char[][] grid, int i, int j, Boolean[][] used) {
        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1 || used[i][j] == Boolean.TRUE || grid[i][j] == '0'){
            return;
        }

        used[i][j] = Boolean.TRUE;
        grid[i][j] = '0';
        DFS(grid, i - 1, j, used);
        DFS(grid, i, j + 1, used);
        DFS(grid, i + 1, j, used);
        DFS(grid, i, j - 1, used);
    }


}
