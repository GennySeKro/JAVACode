package SlidingWindow;

import java.util.HashMap;

public class S2958 {
    /*
    最多K个重复元素的最长子数组
     */

    public int maxSubarrayLength(int[] nums, int k) {
        int res = 1, tempLen = 0;
        int right = 0, left = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while (right < nums.length){
            if (!map.containsKey(nums[right]) || map.get(nums[right]) < k){
                map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
                tempLen++;
                right++;
            }else {
                res = Math.max(res, tempLen);
                while (nums[left] != nums[right]){
                    map.put(nums[left], map.get(nums[left]) - 1);
                    tempLen--;
                    left++;
                }
                map.put(nums[left], map.get(nums[left]) - 1);
                tempLen--;
                left++;
            }
        }
        res = Math.max(res, tempLen);
        return res;
    }
}
