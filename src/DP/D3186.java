package DP;

import java.util.*;

public class D3186 {
    /*
    施咒的最大总伤害
     */

    public long maximumTotalDamage(int[] power) {
        // 统计每个伤害值的总和
        HashMap<Long, Long> mp = new HashMap<>();
        for (int dmg : power) {
            mp.put((long) dmg, mp.getOrDefault((long) dmg, 0L) + (long) dmg);
        }

        // 创建新的数组
        List<Map.Entry<Long, Long>> arr = new ArrayList<>(mp.entrySet());

        // 按照伤害值排序
        Collections.sort(arr, Map.Entry.comparingByKey());

        int n = arr.size();
        long[] dp = new long[n];
        dp[0] = arr.get(0).getValue();

        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1];  // 不选 arr[i]

            // 找到前一个不冲突的值的索引
            int j = i - 1;
            while (j >= 0 && arr.get(j).getKey() >= arr.get(i).getKey() - 2) {
                j--;
            }

            if (j >= 0) {
                dp[i] = Math.max(dp[i], dp[j] + arr.get(i).getValue());
            } else {
                dp[i] = Math.max(dp[i], arr.get(i).getValue());
            }
        }

        return dp[n - 1];
    }
}
