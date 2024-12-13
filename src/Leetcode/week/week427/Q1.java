package Leetcode.week.week427;

import org.junit.Test;

import java.util.Arrays;

public class Q1 {
    /*
    转换数组
     */

    public int[] constructTransformedArray(int[] nums) {
        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++){
            if (nums[i] > 0){
                res[i] = nums[(i + nums[i]) % nums.length];
            } else if (nums[i] < 0) {
                int k = Math.abs(nums[i]) % nums.length;
                if (k < i + 1){
                    res[i] = nums[i - k];
                }else {
                    res[i] = nums[nums.length + i - k];
                }

            }else {
                res[i] = nums[i];
            }
        }

        return res;
    }

    @Test
    public void test(){
        System.out.println(Arrays.toString(constructTransformedArray(new int[]{3,-2,1,1})));
    }
}
