package LCR;

import org.junit.Test;

public class LCR070 {
    /*
    有序数组中的单一元素
     */

    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        int left = 0, right = 1;
        int res = -1;
        for (int i = 0;i < nums.length / 2;i++){
            if (nums[left] != nums[right]){
                res = nums[left];
            }else {
                left = left + 2;
                right = right + 2;
            }
        }
        if (res == -1){
            return nums[nums.length - 1];
        }else {
            return res;
        }
    }

    @Test
    public void test(){
        System.out.println(singleNonDuplicate(new int[]{3,3,7,7,10,11,11}));
    }
}
