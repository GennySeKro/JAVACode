package LCR;

public class LCR089 {
    /*
    打家劫舍
     */

    public int rob(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        } else if (nums.length == 3) {
            return Math.max(nums[1], nums[0] + nums[2]);
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        dp[2] = Math.max(dp[1], dp[0] + nums[2]);
        for (int i = 3;i < nums.length;i++){
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return Math.max(dp[nums.length - 1], dp[nums.length - 2]);
    }
}
