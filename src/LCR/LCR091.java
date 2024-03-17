package LCR;

public class LCR091 {
    /*
    粉刷房子
     */

    public int minCost(int[][] costs) {
        int n = costs.length;
        int[][] dp = new int[n][3];
        //刷第一个颜色
        dp[0][0] = costs[0][0];
        //刷第二个颜色
        dp[0][1] = costs[0][1];
        //刷第三个颜色
        dp[0][2] = costs[0][2];
        for (int i = 1; i < n; i++) {
            //第i个房子刷第一个颜色
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
            //第i个房子刷第二个颜色
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
            //第i个房子刷第三个颜色
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
        }
        return Math.min(Math.min(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]);
    }
}
