package HOT;

import org.junit.Test;

import java.util.Arrays;

public class HOT416 {
    /*
     分割等和子集
     */

    /*
    递归，但是超时
     */
    class one{
        public boolean canPartition(int[] nums) {
            int sum = 0;
            for(int i = 0; i < nums.length;i++){
                sum = sum + nums[i];
            }
            if(sum % 2 == 1){
                return false;
            }else {            Arrays.sort(nums);
                return dfs(nums, sum / 2, 0);
            }
        }

        private boolean dfs(int[] nums, int target, int start) {
            if (target == 0){
                return true;
            }
            for(int i = start;i < nums.length;i++){
                if(i > start && nums[i] == nums[i - 1]){
                    continue;
                }
                if (target < nums[i]){
                    break;
                }

                if (dfs(nums, target - nums[i], i + 1)) {
                    return true;
                }
            }
            return false;
        }
    }

    /*
    动态规划
    二维数组保存转移状态
     */
    class two{
        public boolean canPartition(int[] nums) {
            int len = nums.length;
            int sum = 0;

            for(int num : nums){
                sum = sum + num;
            }
            if(sum % 2 == 1){
                return false;
            }

            int target = sum / 2;

            boolean[][] dp = new boolean[len][target + 1];

            if(nums[0] <= target){
                dp[0][nums[0]] = true;
            }

            for(int i = 1;i < len;i++){
                for(int j = 0;j <= target;j++){
                    dp[i][j] = dp[i-1][j];
                    if(nums[i] == j){
                        dp[i][j] = true;
                        continue;
                    }

                    if(nums[i] < j){
                        dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                    }
                }
                    if(dp[i][sum / 2]){
                        return true;
                    }
            }

            return dp[len-1][target];
        }
    }

    /*
    一维数组从后向前保存转移状态
     */

    class three{
        public boolean canPartition(int[] nums){
            int len = nums.length;
            int sum = 0;
            for(int num : nums){
                sum = sum + num;
            }

            if(sum % 2 == 1){
                return false;
            }

            int target = sum / 2;

            boolean[] dp = new boolean[target + 1];
            dp[0] = true;

            if(nums[0] <= target){
                dp[nums[0]] = true;
            }

            for(int i = 1;i < nums.length;i++){
                for(int j = target;nums[i] < j;j--){
                    if(dp[target]){
                        return true;
                    }
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
            return dp[target];
        }
    }

    @Test
    public void test(){
        System.out.println(new two().canPartition(new int[]{1,5,10,6}));
    }
}
