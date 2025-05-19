package Leetcode.week.week450;

import org.junit.Test;

public class Q1 {
    /*
    数位和等于下标的最小下标
     */

    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++){
            if (indexEqualsSum(nums[i], i)){
                return i;
            }
        }

        return -1;
    }

    private boolean indexEqualsSum(int num, int i) {
        int res = 0;
        while (num != 0){
            res += num % 10;
            num /= 10;
        }

        return res == i;
    }

    @Test
    public void test(){
        System.out.println(smallestIndex(new int[]{1,3,2}));
    }
}
