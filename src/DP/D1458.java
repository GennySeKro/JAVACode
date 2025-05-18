package DP;

public class D1458 {
    /*
    两个子序列的最大点积
     */

    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length, ans = 0;
        int[][] dp = new int[n][m];
        // 一切为了非空
        dp[0][0] = nums1[0] * nums2[0];
        for(int i = 1; i < n; i++) dp[i][0] = Math.max(dp[i - 1][0], nums1[i] * nums2[0]);
        for(int i = 1; i < m; i++) dp[0][i] = Math.max(dp[0][i - 1], nums2[i] * nums1[0]);
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                int product = nums1[i] * nums2[j];
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + product);
                dp[i][j] = Math.max(dp[i][j], product);
            }
        }
        return dp[n - 1][m - 1];
    }
}
