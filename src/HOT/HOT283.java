package HOT;

public class HOT283 {
    /*
    移动零
     */

    public void moveZeroes(int[] nums) {
        int zeroNum = 0;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] == 0){
                zeroNum++;
            }else {
                nums[i-zeroNum] = nums[i];
            }
        }
        for(int i = 0;i < zeroNum;i++){
            nums[nums.length - 1 - i] = 0;
        }
    }
}
