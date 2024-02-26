package HOT;

import org.junit.Test;

public class HOT62 {
    /*
    不同路径
     */

    /*
    二维数组dp
     */
    class one{
        public int uniquePaths(int m, int n){
            int[][] f = new int[m][n];

            for(int i = 0;i<m;i++){
                f[i][0] = 1;
            }
            for(int i = 0;i<n;i++){
                f[0][i] = 1;
            }
            for(int i = 1;i<m;i++){
                for(int j = 1;j<n;j++){
                    f[i][j] = f[i-1][j]+f[i][j-1];
                }
            }
            return f[m-1][n-1];

        }
    }

    /*
    一维数组dp
     */
    class two{
        public int uniquePaths(int m, int n) {
            int[] dp = new int[n];
            for(int i = 0;i < n;i++){
                dp[i] = 1;
            }
            int left = 1;
            for(int i = 1;i < m;i++){
                for(int j = 1;j < n;j++){
                    if(j == 1){
                        left = 1;
                    }
                    dp[j] = dp[j] + left;
                    left = dp[j];
                }
            }
            return dp[n-1];
        }
    }

    @Test
    public void test(){
        System.out.println(new two().uniquePaths(3,7));
    }


}
