public class HOT714 {
    /*
    买卖股票的最佳时机含手续费
     */

    public int maxProfit(int[] prices, int fee) {
        //dp[i][0] 表示第i天持有股票所得最多现金。 dp[i][1] 表示第i天不持有股票所得最多现金
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];

        for(int i = 1; i < prices.length;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]+prices[i]-fee);
        }

        return Math.max(dp[prices.length-1][0],dp[prices.length-1][1]);
    }
}
