package SlidingWindow;

import org.junit.Test;

import java.util.HashMap;

public class S2461 {
    /*
    长度为k子数组中的最大和
     */

    public long maximumSubarraySum(int[] nums, int k) {
        long windowSum = 0L, res = 0L;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0;i < nums.length;i++){
            if (i < k){
                windowSum += nums[i];
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
                if (i == k - 1 && map.size() == k){
                    res = Math.max(res, windowSum);
                }
            }else {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
                if (map.get(nums[i - k]) == 1){
                    map.remove(nums[i - k]);
                }else {
                    map.put(nums[i - k], map.get(nums[i - k]) - 1);
                }
                windowSum = windowSum - nums[i - k] + nums[i];
                if (map.size() == k){
                    res = Math.max(res, windowSum);
                }
            }
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(maximumSubarraySum(new int[]{1,5,4,2,9,9,9}, 3));
    }
}
