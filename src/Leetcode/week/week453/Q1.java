package Leetcode.week.week453;

import org.junit.Test;

import java.util.Arrays;

public class Q1 {
    /*
    数组元素相等转换
     */

    public boolean canMakeEqual(int[] nums, int k) {
        int[] ints = Arrays.copyOf(nums, nums.length);
        return transToSameNum(nums, k, -1) || transToSameNum(ints, k, 1);
    }

    private boolean transToSameNum(int[] nums, int k, int target) {
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == target){
                continue;
            }

            if (i == nums.length - 1){
                return nums[i] == target;
            }

            if (k != 0){
                nums[i] = target;
                nums[i + 1] = -nums[i + 1];
                k--;
            }else {
                return false;
            }
        }

        return true;
    }

    @Test
    public void test(){
        System.out.println(canMakeEqual(new int[]{-1,1,1,1,-1,-1,-1,1,1}, 4));
    }
}
