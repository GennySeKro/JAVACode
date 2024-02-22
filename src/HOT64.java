public class HOT64 {
    /*
    最小路径和
    时间复杂度O(nm)，空间复杂度O(nm)

     */

    public int minPathSum(int[][] grid){
        int[][] f = new int [grid.length][grid[0].length];
        f[0][0] = grid[0][0];
        for(int i = 1;i < grid.length;i++){
            f[i][0] = f[i-1][0] + grid[i][0];
        }
        for(int i = 1;i<grid[0].length;i++){
            f[0][i] = f[0][i-1] + grid[0][i];
        }

        for(int i = 1;i<grid.length;i++){
            for(int j = 1;j<grid[0].length;j++){
                f[i][j] = grid[i][j] + Math.min(f[i-1][j],f[i][j-1]);
            }
        }
        return f[grid.length - 1][grid[0].length - 1];
    }

    /*
    优化：可以直接修改原数组的值，从而空间复杂度可以降到O(1)
     */
    public int minPathSum1(int[][] grid){
        for(int i = 1;i<grid.length;i++){
            grid[i][0] = grid[i-1][0]+grid[i][0];
        }
        for(int i = 1;i < grid[0].length;i++){
            grid[0][i] = grid[0][i-1] + grid[0][i];
        }

        for(int i = 1;i < grid.length;i++){
            for(int j = 1;j < grid[0].length;j++){
                grid[i][j] = grid[i][j] + Math.min(grid[i-1][j],grid[i][j-1]);
            }
        }

        return grid[grid.length-1][grid[0].length-1];
    }
}