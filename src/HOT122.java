public class HOT122 {
    /*
    买卖股票的最佳时机Ⅱ
     */

    /*
    二维数组
    时间复杂度：O(n)，空间复杂度：O(n)
     */
    class one{
        public int maxProfit(int[] prices) {
            int[][] dp = new int[prices.length][2];
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            for(int i = 1;i < prices.length;i++){
                dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] - prices[i]);
            }

            return dp[prices.length-1][0];
        }
    }

    /*
    一维数组
     */
    class two{
        public int maxProfit(int[] prices) {
            int[] dp = new int[2];
            // 0表示持有，1表示卖出
            dp[0] = -prices[0];
            dp[1] = 0;
            for(int i = 1; i <= prices.length; i++){
                // 前一天持有; 既然不限制交易次数，那么再次买股票时，要加上之前的收益
                dp[0] = Math.max(dp[0], dp[1] - prices[i-1]);
                // 前一天卖出; 或当天卖出，当天卖出，得先持有
                dp[1] = Math.max(dp[1], dp[0] + prices[i-1]);
            }
            return dp[1];
        }
    }

    /*
    贪心算法
     */
    class three{
        public int maxProfit(int[] prices) {
            int sum = 0;
            for(int i = 1;i < prices.length;i++){
                sum = sum + Math.max(0,prices[i] - prices[i-1]);
            }
            return sum;
        }
    }

}
