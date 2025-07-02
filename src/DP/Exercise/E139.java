package DP.Exercise;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class E139 {
    /*
    单词拆分
     */

    public boolean wordBreak(String s, List<String> wordDict) {
        int maxWordLen = 0;
        for (String word : wordDict){
            maxWordLen = Math.max(maxWordLen, word.length());
        }

        HashSet<String> set = new HashSet<>(wordDict);

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++){
            for (int j = i - 1; j >= Math.max(i - maxWordLen, 0); j--){
                if (dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
