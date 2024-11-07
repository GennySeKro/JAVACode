package DP;

import org.junit.Test;

import java.util.HashMap;

public class D2606 {
    /*
    找到最大开销的子字符串
     */

    public int maximumCostSubstring(String s, String chars, int[] vals) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0;i < chars.length();i++){
            map.put(chars.charAt(i), vals[i]);
        }

        int res = 0;
        for (int i = 1;i <= s.length();i++){
            int value = map.containsKey(s.charAt(i - 1)) ? map.get(s.charAt(i - 1)) : s.charAt(i - 1) - 'a' + 1;

            dp[i] = dp[i - 1] >= 0 ? dp[i - 1] + value : value;

            res = Math.max(res, dp[i]);
        }
        return res;

    }

    @Test
    public void test(){
        System.out.println(maximumCostSubstring("adaa", "d", new int[]{-1000}));
    }
}
