package Leetcode.fortnight.f158;

import java.util.Arrays;

public class Q2 {
    /*
    买卖股票的最佳时机Ⅴ
     */

    public long maximumProfit(int[] prices, int k) {
        /*
        dp[i][0] 第i笔交易结束时，未持有股票的最大利润
        dp[i][1] 第i笔交易结束时，持有股票的最大利润
        dp[i][2] 第i笔交易结束时，处于做空中的最大利润
         */
        long[][] f = new long[k + 2][3];
        for (int j = 1; j <= k + 1; j++) {
            f[j][1] = Long.MIN_VALUE / 2; // 防止溢出
        }
        f[0][0] = Long.MIN_VALUE / 2;
        for (int p : prices) {
            for (int j = k + 1; j > 0; j--) {
                f[j][0] = Math.max(f[j][0], Math.max(f[j][1] + p, f[j][2] - p));
                f[j][1] = Math.max(f[j][1], f[j - 1][0] - p);
                f[j][2] = Math.max(f[j][2], f[j - 1][0] + p);
            }
        }
        return f[k + 1][0];
    }
}