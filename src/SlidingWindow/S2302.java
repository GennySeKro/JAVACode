package SlidingWindow;

import org.junit.Test;

public class S2302 {
    /*
    统计得分小于K的子数组数目
     */

    public long countSubarrays(int[] nums, long k) {

        int left = 0, right = 0;
        long res = 0, tempSum = 0;

        while (right < nums.length){
            tempSum += nums[right];

            while (tempSum * (right - left + 1) >= k){
                tempSum -= nums[left];
                left++;
            }

            res += right - left + 1;
            right++;
        }

        return res;
    }

    @Test
    public void test(){
        System.out.println(countSubarrays(new int[]{2,1,4,3,5}, 10));
    }
}
