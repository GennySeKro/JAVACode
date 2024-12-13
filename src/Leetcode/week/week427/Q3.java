package Leetcode.week.week427;

import java.util.Arrays;

public class Q3 {
    /*
    长度可被K整除的子数组的最大元素和
     */

    public long maxSubarraySum(int[] nums, int k) {
        long[] max = new long[k];
        Arrays.fill(max, Long.MAX_VALUE / 2);
        max[0] = 0;
        long sum = 0, res = Long.MIN_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (i >= k - 1) res = Math.max(res, sum - max[(i + 1) % k]);
            max[(i + 1) % k] = Math.min(max[(i + 1) % k], sum);
        }
        return res;
    }
}
