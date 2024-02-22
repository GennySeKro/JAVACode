import org.junit.Test;

public class HOT377 {
    /*
    组合总和Ⅳ
     */

    /*
    回溯
     */
    class one{
        int max = 0;
        public int combinationSum4(int[] nums, int target) {
            backTracking(nums,target);
            return max;
        }

        private void backTracking(int[] nums, int target) {
            if(target == 0){
                max++;
            } else if (target < 0) {
                return;
            }
            for(int i = 0;i < nums.length;i++){
                backTracking(nums,target-nums[i]);
            }
        }
    }

    /*
    动态规划
     */
    class two{
        public int combinationSum4(int[] nums, int target) {
            int[] dp = new int[target + 1];
            dp[0] = 1;
            for (int i = 0; i <= target; i++) {
                for (int j = 0; j < nums.length; j++) {
                    if (i >= nums[j]) {
                        dp[i] += dp[i - nums[j]];
                    }
                }
            }
            return dp[target];
        }
    }

    @Test
    public void test(){
        System.out.println(new two().combinationSum4(new int[]{1, 2, 3},32));
    }


}
