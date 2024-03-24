package rating1500_1700;

public class G1558 {
    /*
    得到目标数组的最少函数调用次数
     */

    public int minOperations(int[] nums) {
        int res = 0, max = 0;
        for (int i = 0;i < nums.length;i++){
            max = Math.max(max, nums[i]);
            while (nums[i] != 0){
                if (nums[i] % 2 == 1){
                    res++;
                }
                nums[i] = nums[i] / 2;
            }
        }
        if (max != 0){
            while (max != 0){
                res++;
                max = max / 2;
            }
            res--;
        }
        return res;
    }
}
