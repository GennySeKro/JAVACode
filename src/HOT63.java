import org.junit.Test;

public class HOT63 {
    /*
    不同路径Ⅱ
     */


    /*
    二维数组dp
     */
    class one{
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
            boolean Obstacale = false;
            for(int i = 0; i < obstacleGrid[0].length;i++){
                if(!Obstacale){
                    if(obstacleGrid[0][i] == 1){
                        dp[0][i] = 0;
                        Obstacale = true;
                    }else {
                        dp[0][i] = 1;
                    }
                }else {
                    dp[0][i] = 0;
                }
            }

            Obstacale = false;

            for(int i = 0;i < obstacleGrid.length;i++){
                if(!Obstacale){
                    if(obstacleGrid[i][0] == 1){
                        dp[i][0] = 0;
                        Obstacale = true;
                    }else {
                        dp[i][0] = 1;
                    }
                }else {
                    dp[i][0] = 0;
                }
            }
            for(int i = 1;i <obstacleGrid.length;i++){
                for(int j = 1;j < obstacleGrid[0].length;j++){
                    if(obstacleGrid[i][j] == 1){
                        dp[i][j] = 0;
                    }else {
                        dp[i][j] = dp[i-1][j] + dp[i][j-1];
                    }
                }
            }
            return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
        }
    }

    /*
    一维数组dp
     */
//    class two{
//        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//            int[] dp = new int[obstacleGrid[0].length];
//
//        }
//    }

    @Test
    public void test(){
        System.out.println(new one().uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
    }
}
