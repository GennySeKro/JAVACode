package LCR;

import org.junit.Test;

public class LCR009 {
    /*
    乘积小于K的子数组
     */

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0;
        int left = 0, right = 0;
        long sum = 1;
        while (right < nums.length){
            sum = sum * nums[right];
            while (sum >= k && left <= right){
                sum = sum / nums[left];
                left++;
            }
            res = res + right - left + 1;
            right++;
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(numSubarrayProductLessThanK(new int[]{10,5,2,6}, 100));
    }
}
