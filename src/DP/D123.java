package DP;

public class D123 {
    /*
    买卖股票的最佳时机Ⅲ
     */

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][4];
        //第一次买入
        dp[0][0] = -prices[0];
        //第一次卖出
        dp[0][1] = 0;
        //第二次买入
        dp[0][2] = -prices[0];
        //第二次卖出
        dp[0][3] = 0;

        for (int i = 1; i < prices.length; i++){
            dp[i][0] = Math.max(-prices[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
            dp[i][2] = Math.max(dp[i - 1][1] - prices[i], dp[i - 1][2]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] + prices[i]);
        }

        return Math.max(dp[prices.length - 1][1], dp[prices.length - 1][3]);
    }
}
