package LCR;

import org.junit.Test;

public class LCR012 {
    /*
    寻找数组的中心下标
     */

    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int i = 0;i < nums.length;i++){
            sum = sum + nums[i];
        }
        int leftSum = 0;
        for (int i = 0;i < nums.length;i++){
            if (leftSum * 2 == sum - nums[i]){
                return i;
            }else {
                leftSum = leftSum + nums[i];
            }
        }
        return -1;
    }

    @Test
    public void test(){
        System.out.println(pivotIndex(new int[]{2,1,-1}));
    }
}
