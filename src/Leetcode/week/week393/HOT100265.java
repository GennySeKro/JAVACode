package Leetcode.week.week393;

import org.junit.Test;

public class HOT100265 {
    /*
    素数的最大距离
     */

    public int maximumPrimeDifference(int[] nums) {
        int left = 0, right = nums.length - 1;
        for (int i = 0;i < nums.length;i++){
            if (isPrimeNumber(nums[i])){
                left = i;
                break;
            }
        }
        for (int i = nums.length - 1;i >= left;i--){
            if (isPrimeNumber(nums[i])){
                right = i;
                break;
            }
        }
        return right - left;
    }

    private boolean isPrimeNumber(int num) {
        if (num == 1){
            return false;
        }
        for (int i = 2;i * i <= num;i++){
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }

    @Test
    public void test(){
        System.out.println(maximumPrimeDifference(new int[]{1,7}));
    }
}
