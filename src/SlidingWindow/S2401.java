package SlidingWindow;

public class S2401 {
    /*
    最长优雅子数组
     */

    public int longestNiceSubarray(int[] nums) {
        int res = 1, tempValue = 0;
        int left = 0, right = 0;

        while (right < nums.length){
            while ((tempValue & nums[right]) > 0){
                tempValue ^= nums[left];
                left++;
            }
            tempValue |= nums[right];
            res = Math.max(res, right - left + 1);

            right++;
        }

        return res;
    }
}
