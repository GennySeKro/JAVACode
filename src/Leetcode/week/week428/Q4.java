package Leetcode.week.week428;

import java.util.Arrays;

public class Q4 {
    /*
    使字符频率相等的最少操作次数
     */

    public int makeStringGood(String s) {
        int[] cnt = new int[26];
        for (char b : s.toCharArray()){
            cnt[b - 'a']++;
        }

        int m = Arrays.stream(cnt).max().getAsInt();
        int ans = s.length();
        int[] dp = new int[27];

        for (int target = 0;target <= m;target++){
            dp[25] = Math.min(cnt[25], Math.abs(cnt[25] - target));
            for (int i = 24;i >= 0;i--){
                int x = cnt[i];
                int y = cnt[i + 1];

                dp[i] = dp[i + 1] + Math.min(x, Math.abs(x - target));

                if (y < target){
                    int t = x > target ? target : 0;
                    dp[i] = Math.min(dp[i], dp[i + 2] + Math.max(x - t, target - y));
                }
            }
            ans = Math.min(ans, dp[0]);
        }
        return ans;
    }
}
