package DP.Exercise;

import java.util.HashSet;
import java.util.List;

public class E2707 {
    /*
    字符串中的额外字符
     */

    public int minExtraChar(String s, String[] dictionary) {
        HashSet set = new HashSet<>(List.of(dictionary));
        int[] dp = new int[s.length() + 1];

        for (int i = 0; i < s.length(); i++){
            dp[i + 1] = dp[i] + 1;
            for (int j = 0; j <= i; j++){
                if (set.contains(s.substring(j, i + 1))){
                    dp[i + 1] = Math.min(dp[i + 1], dp[j]);
                }
            }
        }

        return dp[s.length()];
    }
}
