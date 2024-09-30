package SlidingWindow;

import org.junit.Test;

import java.util.Arrays;

public class S1838 {
    /*
    最高频元素的频数
     */

    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 1;
        long tempSum = 0;
        int left = 0;

        for (int i = 1;i < nums.length;i++){
            tempSum += (long) (nums[i] - nums[i - 1]) * (i - left);
            while (tempSum > k){
                tempSum -= (nums[i] - nums[left]);
                left++;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(maxFrequency(new int[]{1,1,1,1,1}, 1));
    }
}
