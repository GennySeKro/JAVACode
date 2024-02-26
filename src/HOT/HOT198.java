package HOT;

public class HOT198 {
    /*
    打家劫舍
    时间复杂度O(n),空间复杂度O(n)
     */
    public int rob(int[] nums) {

        int max = 0;
        int[] dp = new int[nums.length];
        if(nums.length == 1){
            return nums[0];
        }else if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i = 2;i < nums.length;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2] + nums[i]);
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
