package LCR;

import org.junit.Test;

public class LCR020 {
    /*
    回文子串
     */

    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0;i < s.length();i++){
            dp[i][i] = true;
        }
        int res = s.length();
        for (int i = 1;i < s.length();i++){
            for (int j = i - 1;j >= 0;j--){
                if (j == i - 1){
                    dp[j][i] = s.charAt(j) == s.charAt(i);
                }else {
                    dp[j][i] = dp[j + 1][i - 1] && s.charAt(j) == s.charAt(i);
                }
                if (dp[j][i]){
                    res++;
                }
            }
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(countSubstrings("abc"));
    }
}
