package Leetcode.week.week403;

import org.junit.Test;

import java.util.Arrays;

public class HOT100342 {
    /*
    最小元素和最大元素的最小平均值
     */

    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        double res = Double.MAX_VALUE;
        while (left < right){
            double temp = (nums[left] + nums[right]) / 2.0;
            res = Math.min(temp, res);
            left++;
            right--;
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(minimumAverage(new int[]{1,9,8,3,10,5}));
    }
}
