package DP;

import org.junit.Test;

public class D2266 {
    /*
    统计打字方案数
     */

    public int countTexts(String pressedKeys) {
        int mod = (int) 1e9 + 7;
        // 分两种情况，当前i与i-1的字符相同，不相同
        // 不相同：dp[i] += dp[i - 1]
        // 相同：与i-1相同 dp[i] += dp[i-1] + dp[i-2]
        // 与i-2也相同：dp[i] += dp[i-3]
        int n = pressedKeys.length();
        char[] chs = pressedKeys.toCharArray();
        // dp[i]表示以pressKey[i]结尾的方案个数
        long[] dp = new long[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1];
            if (chs[i] == chs[i - 1]) {
                dp[i] += i >= 2 ? dp[i - 2] : 1;
                if (i >= 2 && chs[i] == chs[i - 2]) {
                    dp[i] += i >= 3 ? dp[i - 3] : 1;
                    if ((chs[i] == '7' || chs[i] == '9') && i >= 3 && chs[i] == chs[i - 3]) {
                        dp[i] += i >= 4 ? dp[i - 4] : 1;
                    }
                }
            }
            dp[i] %= mod;
        }
        return (int) dp[n - 1];
    }

    @Test
    public void test(){
        System.out.println(countTexts("22233"));
    }
}
