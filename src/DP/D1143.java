package DP;

public class D1143 {
    /*
    最长公共子序列
     */

    public int longestCommonSubsequence(String text1, String text2) {
        char[] s = text1.toCharArray();
        char[] t = text2.toCharArray();

        int n = s.length;
        int m = t.length;

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                dp[i + 1][j + 1] = s[i] == t[j] ? dp[i][j] + 1 :
                        Math.max(dp[i][j + 1], dp[i + 1][j]);
            }
        }

        return dp[n][m];
    }
}
