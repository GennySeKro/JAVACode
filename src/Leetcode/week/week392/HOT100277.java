package Leetcode.week.week392;

import java.util.Arrays;

public class HOT100277 {
    /*
    使数组中位数等于 K 的最少操作数
     */

    public long minOperationsToMakeMedianK(int[] nums, int k) {
        Arrays.sort(nums);
        long res = 0;

        for (int i = 0;i < nums.length / 2;i++){
            if (nums[i] > k){
                res = res + nums[i] - k;
            }
        }
        for (int i = nums.length / 2 + 1;i < nums.length;i++){
            if (nums[i] < k){
                res = res + k - nums[i];
            }
        }

        res = res + Math.abs(nums[nums.length / 2] - k);
        return res;
    }
}
