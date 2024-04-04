package rating1500_1700;

public class G1254 {
    /*
    统计封闭岛屿的数目
     */

    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        //判断左右边界
        for(int i = 0;i < m;i++){
            dfs(grid,i,0);
            dfs(grid,i,n-1);
        }
        //判断上下边界
        for(int i = 0;i < n;i++){
            dfs(grid,0,i);
            dfs(grid,m-1,i);
        }
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                //统计个数
                if(grid[i][j] == 0){
                    dfs(grid,i,j);
                    ans++;
                }
            }
        }
        return ans;
    }

    public void dfs(int[][] grid,int row,int col){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 1) return;
        grid[row][col] = 1;
        dfs(grid,row+1,col);
        dfs(grid,row-1,col);
        dfs(grid,row,col+1);
        dfs(grid,row,col-1);
    }
}
