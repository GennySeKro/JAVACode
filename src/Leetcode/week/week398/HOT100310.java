package Leetcode.week.week398;

import org.junit.Test;

public class HOT100310 {
    /*
    特殊数组Ⅰ
     */

    public boolean isArraySpecial(int[] nums) {
        if (nums.length == 1){
            return true;
        }
        for (int i = 0;i < nums.length - 1;i++){
            if (!(nums[i] % 2 == 0 && nums[i + 1] % 2 != 0 || nums[i] % 2 != 0 && nums[i + 1] % 2 == 0)){
                return false;
            }
        }
        return true;
    }

    @Test
    public void test(){
        System.out.println(isArraySpecial(new int[]{4,3,1,6}));
    }
}
