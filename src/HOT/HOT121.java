package HOT;

public class HOT121 {
    /*
    买股票的最佳时机
     */

    /*
    贪心算法
     */
    class one{
        public int maxProfit(int[] prices) {
            int minprice = Integer.MAX_VALUE;
            int maxprofit = 0;
            for (int i = 0; i < prices.length; i++) {
                if (prices[i] < minprice) {
                    minprice = prices[i];
                } else if (prices[i] - minprice > maxprofit) {
                    maxprofit = prices[i] - minprice;
                }
            }
            return maxprofit;
        }
    }

    /*
    动态规划
     */
    class two{
        public int maxProfit(int[] prices) {
            int[] dp = new int[2];
            // 记录一次交易，一次交易有买入卖出两种状态
            // 0代表持有，1代表卖出
            dp[0] = -prices[0];
            dp[1] = 0;
            // 可以参考斐波那契问题的优化方式
            // 我们从 i=1 开始遍历数组，一共有 prices.length 天，
            // 所以是 i<=prices.length
            for (int i = 1; i <= prices.length; i++) {
                // 前一天持有；或当天买入
                dp[0] = Math.max(dp[0], -prices[i - 1]);
                // 如果 dp[0] 被更新，那么 dp[1] 肯定会被更新为正数的 dp[1]
                // 而不是 dp[0]+prices[i-1]==0 的0，
                // 所以这里使用会改变的dp[0]也是可以的
                // 当然 dp[1] 初始值为 0 ，被更新成 0 也没影响
                // 前一天卖出；或当天卖出, 当天要卖出，得前一天持有才行
                dp[1] = Math.max(dp[1], dp[0] + prices[i - 1]);
            }
            return dp[1];
        }
    }

}
