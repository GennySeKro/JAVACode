import org.junit.Test;

public class HOT674 {
    /*
    最长连续递增序列
     */

    public int findLengthOfLCIS(int[] nums) {
        int max = 1;
        int res = 0;
        for(int i = 1;i < nums.length;i++){
            if(nums[i] > nums[i - 1]){
               max++;
            }else {
                res = Math.max(max,res);
                max = 1;
            }
        }
        res = Math.max(max,res);
        return res;
    }

    @Test
    public void test(){
        System.out.println(findLengthOfLCIS(new int[]{1,3,5,7}));
    }
}
