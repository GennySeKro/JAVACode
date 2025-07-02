package DP.Exercise;

import java.util.Arrays;

public class E132 {
    /*
    分割回文串Ⅱ
     */

    public int minCut(String s) {
        char[] sCharArray = s.toCharArray();
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for (boolean[] row : isPalindrome){
            Arrays.fill(row, true);
        }

        for (int left = s.length() - 2; left >= 0; left--){
            for (int right = left + 1; right < s.length(); right++){
                isPalindrome[left][right] = sCharArray[left] == sCharArray[right] && isPalindrome[left + 1][right - 1];
            }
        }

        int[] dp = new int[s.length()];
        for (int right = 0; right < s.length(); right++){
            if (isPalindrome[0][right]){
                continue;
            }

            int res = Integer.MAX_VALUE;
            for (int left = 1; left <= right; left++){
                if (isPalindrome[left][right]){
                    res = Math.min(res, dp[left - 1] + 1);
                }
            }

            dp[right] = res;
        }

        return dp[s.length() - 1];
    }
}
