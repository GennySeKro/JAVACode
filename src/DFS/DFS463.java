package DFS;


import org.junit.Test;

public class DFS463 {
    /*
    岛屿的周长
     */

    public int islandPerimeter(int[][] grid) {
        Boolean[][] used = new Boolean[grid.length][grid[0].length];
        for (int i = 0;i < grid.length;i++){
            for (int j = 0;j < grid[0].length;j++){
                if (grid[i][j] == 1){
                    return DFS(grid, i, j, used);
                }
            }
        }
        return 0;
    }

    private int DFS(int[][] grid, int i, int j, Boolean[][] used) {
        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1 || grid[i][j] == 0){
            return 1;
        }
        if (used[i][j] == Boolean.TRUE){
            return 0;
        }


        used[i][j] = Boolean.TRUE;
        return DFS(grid, i - 1, j, used) + DFS(grid, i, j + 1, used) +
                DFS(grid, i + 1, j, used) + DFS(grid, i, j - 1, used);
    }

    @Test
    public void test(){
        System.out.println(islandPerimeter(new int[][]{{1,0}}));
    }
}
