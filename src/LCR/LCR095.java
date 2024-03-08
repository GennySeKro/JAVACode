package LCR;

import java.util.Map;

public class LCR095 {
    /*
    最长公共子序列
     */

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        boolean flag = false;
        for (int i = 0;i < text1.length();i++){
            if (flag){
                dp[i][0] = 1;
            }else {
                if (text1.charAt(i) == text2.charAt(0)){
                    dp[i][0] = 1;
                    flag = true;
                }
            }
        }
        flag = false;
        for (int i = 0;i < text2.length();i++){
            if (flag){
                dp[0][i] = 1;
            }else {
                if (text2.charAt(i) == text1.charAt(0)){
                    dp[0][i] = 1;
                    flag = true;
                }
            }
        }
        for (int i = 1;i < text1.length();i++){
            for (int j = 1;j < text2.length();j++){
                if (text1.charAt(i) == text2.charAt(j)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[text1.length() - 1][text2.length() - 1];
    }


}
