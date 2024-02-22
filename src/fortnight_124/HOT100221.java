package fortnight_124;

public class HOT100221 {
    /*
    相同分数的最大操作数目 I
     */

    public int maxOperations(int[] nums) {
        int sum = nums[0] + nums[1];
        int num = 2, res = 1;
        for (int i = 2;nums.length - i >= 2;i++){
            if (nums[i] + nums[i + 1] == sum){
                res++;
                i++;
            }else {
                break;
            }
        }
        return res;
    }
}
