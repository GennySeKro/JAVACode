package HOT100;

import java.util.Arrays;

public class HOT62 {
    /*
    不同路径
     */

    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
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
