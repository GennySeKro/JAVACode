package LCR;

public class LCR101 {
    /*
    分割等和子集
     */

    /*
    递归：超时
    时间复杂度O(n * n)
    空间复杂度O(n)
     */
    class one{
        public boolean canPartition(int[] nums) {
            int sum = 0;
            for (int i = 0;i < nums.length;i++){
                sum = sum + nums[i];
            }
            if (sum % 2 == 1){
                return false;
            }
            int target = sum / 2;
            return dfs(nums, 0, target);
        }

        private boolean dfs(int[] nums, int index, int target) {
            if (target == 0){
                return true;
            }
            if (target < 0){
                return false;
            }
            boolean flag = false;
            for(int i = index;i < nums.length;i++){
                flag = dfs(nums, i + 1, target - nums[i]) || flag;
            }
            return flag;
        }
    }

    /*
    背包问题：动态规划
    时间复杂度O(n)
    空间复杂度O(n)
     */
    class two{
        public boolean canPartition(int[] nums){
            int sum = 0;
            for (int i = 0;i < nums.length;i++){
                sum = sum + nums[i];
            }
            if (sum % 2 == 1){
                return false;
            }
            int target = sum / 2;
            int[] dp = new int[target + 1];
            dp[0] = 1;
            for (int i = 0;i < nums.length;i++){
                for (int j = target;j >= nums[i];j--){
                    dp[j] = dp[j] + dp[j - nums[i]];
                }
            }
            if (dp[target] != 0){
                return true;
            }else {
                return false;
            }
        }
    }
}
