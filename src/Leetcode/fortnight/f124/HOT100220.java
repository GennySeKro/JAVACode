package Leetcode.fortnight.f124;

import java.util.HashMap;
import java.util.Map;

public class HOT100220 {
    /*
    相同分数的最大操作数目 II
     */

    private Map<Integer, int[][]> cache;

    public int maxOperations(int[] nums) {
        int n = nums.length;
        cache = new HashMap<>();

        cache.put(nums[0] + nums[n - 1], new int[n + 1][n + 1]);
        cache.put(nums[0] + nums[1], new int[n + 1][n + 1]);
        cache.put(nums[n - 2] + nums[n - 1], new int[n + 1][n + 1]);

        return Math.max(dfs(nums, 0, n - 1, nums[0] + nums[n - 1]),
                Math.max(dfs(nums, 0, n - 1, nums[0] + nums[1]), dfs(nums, 0, n - 1, nums[n - 2] + nums[n - 1])));
    }

    private int dfs(int[] nums, int l, int r, int k) {
        if (l >= r) return 0;
        if (cache.containsKey(k) && cache.get(k)[l][r] != 0){
            return cache.get(k)[l][r];
        }

        int rst = 0;
        if ((nums[l] + nums[l + 1]) == k)
            rst = Math.max(rst, 1 + dfs(nums, l + 2, r, k));
        if ((nums[r - 1] + nums[r]) == k)
            rst = Math.max(rst, 1 + dfs(nums, l, r - 2, k));
        if ((nums[l] + nums[r]) == k)
            rst = Math.max(rst, 1 + dfs(nums, l + 1, r - 1, k));

        if (!cache.containsKey(k)){
            cache.put(k, new int[nums.length + 1][nums.length + 1]);
        }
        cache.get(k)[l][r] = rst;
        return rst;
    }
}
