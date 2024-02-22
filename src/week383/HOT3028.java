package week383;

public class HOT3028 {
    /*
    边界上的蚂蚁
     */

    public int returnToBoundaryCount(int[] nums) {
        int res = 0, sum = 0;
        for (int i = 0;i < nums.length;i++){
            sum = sum + nums[i];
            if (sum == 0){
                res++;
            }
        }
        return res;
    }
}
