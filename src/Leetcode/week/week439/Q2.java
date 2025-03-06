package Leetcode.week.week439;

import org.junit.Test;

public class Q2 {
    /*
    至多K次操作后的最长回文子序列
     */

    public int longestPalindromicSubsequence(String s, int k) {
        int len = s.length();
        int[][][] dp = new int[len][len][k + 1];

        for (int i = 0;i < len; i++){
             int st = 0, ed = i;
             while (ed < len){
                 int diff = mininum(s.charAt(st) - 'a', s.charAt(ed) - 'a');
                 for (int j = 0; j <= k; j++){
                     if (i == 0){
                         dp[st][ed][j] = 1;
                     }else {
                         dp[st][ed][j] = Math.max(dp[st][ed - 1][j], dp[st + 1][ed][j]);
                         if (j != 0){
                             dp[st][ed][j] = Math.max(dp[st][ed][j - 1], dp[st][ed][j]);
                         }

                         if (j >= diff){
                             dp[st][ed][j] = Math.max(dp[st][ed][j], dp[st + 1][ed - 1][j - diff] + 2);
                         }
                     }
                 }
                 st++;
                 ed++;
             }
        }
        return dp[0][len - 1][k];
    }

    private int mininum(int st, int ed) {
        int res = Integer.MAX_VALUE;
        for (int i = 0;i < 26; i++){
            res = Math.min(res, Math.min(Math.abs(i - st), 26 - Math.abs(i - st)) + Math.min(Math.abs(i - ed), 26 - Math.abs(i - ed)));
        }

        return res;
    }


    @Test
    public void test(){
        System.out.println(longestPalindromicSubsequence("wehzr", 3));
    }
}
