package SlidingWindow;

import org.junit.Test;

public class S713 {
    /*
    乘积小于K的子数组
     */

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1){
            return 0;
        }
        int tempSum = 1, res = 0;
        int left = 0, right = 0;

        while (right < nums.length){
            tempSum *= nums[right];
            while (tempSum >= k){
                tempSum /= nums[left];
                left++;
            }
            res += right - left + 1;
            right++;
        }

        return res;
    }

    @Test
    public void test(){
        System.out.println(numSubarrayProductLessThanK(new int[]{10,5,2,6}, 100));
    }
}
