package HOT;

public class HOT494 {
    /*
    目标和
     */

    /*
    回溯
    时间复杂度O(2^n)
    空间复杂度O(n
     */
    class one{
        int count = 0;
        public int findTargetSumWays(int[] nums, int target) {
            backtrack(nums,target,0,0);
            return count;
        }

        private void backtrack(int[] nums, int target, int index, int sum) {
            if(index == nums.length){
                if(sum == target){
                    count++;
                }
            }else {
                backtrack(nums,target,index+1,sum+nums[index]);
                backtrack(nums,target,index+1,sum-nums[index]);
            }
        }
    }

    /*
    动态规划
     */
    class two{
        public int findTargetSumWays(int[] nums, int target) {
            int sum = 0;
            for(int i = 0;i < nums.length;i++){
                sum = sum + nums[i];
            }
            if(target < 0 && sum < -target){
                return 0;
            }
            if((target+sum) % 2 == 1){
                return 0;
            }

            int size = (target + sum) / 2;
            if(size < 0){
                size = -size;
            }

            int[] dp = new int[size + 1];
            dp[0] = 1;
            for(int i = 0;i < nums.length;i++){
                for(int j = size;j >= nums[i];j--){
                    dp[j] = dp[j] + dp[j-nums[i]];
                }
            }

            return dp[size];
        }
    }

}
