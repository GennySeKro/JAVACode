package SlidingWindow;

import java.util.Arrays;

public class S2779 {
    /*
    数组的最大美丽值
     */

    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 1, tempLen = 0;
        int left = 0, right = 0;

        while (right < nums.length){
            if (nums[right] - nums[left] <= 2 * k){
                right++;
                tempLen++;
            }else {
                res = Math.max(res, tempLen);
                while (nums[right] - nums[left] > 2 * k){
                    left++;
                    tempLen--;
                }
            }
        }

        res = Math.max(res, tempLen);
        return res;
    }
}
