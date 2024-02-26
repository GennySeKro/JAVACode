package HOT;

import org.junit.Test;

public class HOT53 {
    /*
    最大子数组和
     */

    /*
    动态规划
    时间复杂度O(n)
    空间复杂度O(1)
     */
    class one{
        public int maxSubArray(int[] nums) {
            int res = nums[0];
            for(int i = 1; i < nums.length;i++){
                nums[i] = nums[i] + Math.max(nums[i - 1],0);
                res = Math.max(res,nums[i]);
            }
            return res;
        }
    }


    /*
    贪心算法
    时间复杂度O(n)
    空间复杂度O(1)
     */
    class two{
        public int maxSubArray(int[] nums) {
            int sum = 0;
            int max = nums[0];
            for(int i = 0;i < nums.length;i++){
                if(sum + nums[i] < 0){
                    max = Math.max(max,nums[i]);
                    sum = 0;
                    continue;
                }else{
                    sum = sum + nums[i];
                    max = Math.max(max,sum);
                }
            }
            return max;
        }
    }
    @Test
    public void test(){
        System.out.println(new one().maxSubArray(new int[]{-1,-2}));
    }
}
