package HOT100;

import org.junit.Test;

public class HOT283 {
    /*
    移动零
     */

    public void moveZeroes(int[] nums) {
        int zeroNum = 0;
        for (int i = 0;i < nums.length;i++){
            if (nums[i] == 0){
                zeroNum++;
            }else {
                nums[i - zeroNum] = nums[i];
            }
        }
        for (int i = nums.length - zeroNum;i < nums.length;i++){
            nums[i] = 0;
        }
    }

    @Test
    public void test(){
        moveZeroes(new int[]{0,1,0,3,12});
    }
}
