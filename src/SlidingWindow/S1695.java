package SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;

public class S1695 {
    /*
    删除子数组的最大得分
     */

    public int maximumUniqueSubarray(int[] nums) {
        int right = 0, left = 0;
        int tempSum = 0, res = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();

        while (right < nums.length){
            if (!set.contains(nums[right])){
                tempSum += nums[right];
                set.add(nums[right]);
                right++;
            }else {
                res = Math.max(res, tempSum);
                while (nums[left] != nums[right]){
                    tempSum -= nums[left];
                    set.remove(nums[left]);
                    left++;
                }
                tempSum -= nums[left];
                set.remove(nums[left]);
                left++;
            }
        }
        res = Math.max(res, tempSum);
        return res;
    }
}
