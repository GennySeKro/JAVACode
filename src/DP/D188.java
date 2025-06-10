package DP;

import java.util.Arrays;

public class D188 {
    /*
    买卖股票的最佳时机Ⅳ
     */

    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[k + 2][2];
        for (int i = 0; i < dp.length; i++){
            dp[i][1] = Integer.MIN_VALUE / 2;//防止溢出
        }
        dp[0][0] = Integer.MIN_VALUE / 2;
        for (int p : prices){
            for (int i = k + 1; i > 0; i--){
                dp[i][0] = Math.max(dp[i][0], dp[i][1] + p);
                dp[i][1] = Math.max(dp[i][1], dp[i - 1][0] - p);
            }
        }
        return dp[k + 1][0];
    }
}
