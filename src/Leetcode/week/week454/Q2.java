package Leetcode.week.week454;

import java.util.HashMap;

public class Q2 {
    /*
    统计特殊三元组
     */

    public int specialTriplets(int[] nums) {
        HashMap<Integer, Integer> rightMap = new HashMap<>();
        for (int i = 1 ; i < nums.length; i++){
            rightMap.put(nums[i], rightMap.getOrDefault(nums[i], 0) + 1);
        }

        HashMap<Integer, Integer> leftMapMap = new HashMap<>();
        leftMapMap.put(nums[0], 1);
        long res = 0L;
        for (int i = 1; i < nums.length - 1; i++){
            rightMap.put(nums[i], rightMap.get(nums[i]) - 1);
            res += (long) rightMap.getOrDefault(nums[i] * 2, 0) * leftMapMap.getOrDefault(nums[i] * 2, 0);
            res = res % 1000000007;
            leftMapMap.put(nums[i], leftMapMap.getOrDefault(nums[i], 0) + 1);
        }

        return (int) (res % 1000000007);
    }
}
