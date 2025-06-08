package Leetcode.week.week452;

import org.junit.Test;

import java.util.Arrays;

public class Q1 {
    /*
    等积子集的划分方案
     */

    public boolean checkEqualPartitions(int[] nums, long target) {
        return dfs(0, 1, 1, nums, target);
    }

    private boolean dfs(int i, long leftArray, long rightArray, int[] nums, long target) {
        if (leftArray > target || rightArray > target){
            return false;
        }

        if (i == nums.length){
            return leftArray == target && rightArray == target;
        }

        return dfs(i + 1, leftArray * nums[i], rightArray, nums, target) ||
                dfs(i + 1, leftArray, rightArray * nums[i], nums, target);
    }


    @Test
    public void test(){
        System.out.println(checkEqualPartitions(new int[]{3,1,6,8,4}, 24));
    }
}
