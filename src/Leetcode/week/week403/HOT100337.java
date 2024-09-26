package Leetcode.week.week403;

import org.junit.Test;

public class HOT100337 {
    /*
    最大化子数组的总成本
     */

    public long maximumTotalCost(int[] nums) {
        long res = nums[0];
        int index = 0;
        for (int i = 1;i < nums.length;i++){
            if (nums[i] < 0){
                
            }
        }
        //todo
        return 0l;
    }

    @Test
    public void test(){
        System.out.println(maximumTotalCost(new int[]{1,-2,3,4}));
    }
}
