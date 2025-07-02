package DP.Exercise;

import org.junit.Test;

public class E2369 {
    /*
    检查数组是否存在有效划分
     */

    public boolean validPartition(int[] nums) {
        if (nums.length == 2){
            return nums[0] == nums[1];
        }

        boolean[] dp = new boolean[nums.length + 1];
        dp[1] = false;
        dp[2] = nums[0] == nums[1];
        dp[3] = nums[0] == nums[1] && nums[1] == nums[2] || (nums[0] + 1 == nums[1]) && (nums[1] + 1 == nums[2]);

        for (int i = 3; i < nums.length; i++){
            if (dp[i - 1] && nums[i] == nums[i - 1]){
                dp[i + 1] = true;
            } else if (dp[i - 2] && nums[i - 2] == nums[i - 1] && nums[i - 1] == nums[i]) {
                dp[i + 1] = true;
            } else if (dp[i - 2] && (nums[i - 2] + 1 == nums[i - 1]) && (nums[i - 1] + 1 == nums[i])) {
                dp[i + 1] = true;
            }else {
                dp[i + 1] = false;
            }
        }

        return dp[nums.length];
    }

    @Test
    public void test(){
        System.out.println(validPartition(new int[]{348054,7876,34051}));
    }
}
