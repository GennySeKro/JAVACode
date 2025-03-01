package HOT100;

import java.util.Arrays;

public class HOT416 {
    /*
    分割等和子集
     */

    public boolean canPartition(int[] nums) {
        int s = 0;
        for (int num : nums){
            s += num;
        }

        if (s % 2 != 0){
            return false;
        }

        int[][] memo = new int[nums.length][s / 2 + 1];
        for (int[] row : memo){
            Arrays.fill(row, - 1);
        }

        return dfs(nums.length - 1, s / 2, memo, nums);
    }

    private boolean dfs(int i, int j, int[][] memo, int[] nums) {
        if (i < 0){
            return j == 0;
        }

        if (memo[i][j] != -1){
            return memo[i][j] == 1;
        }

        boolean res = j >= nums[i] && dfs(i - 1, j - nums[i], memo, nums) || dfs(i - 1, j, memo, nums);
        memo[i][j] = res ? 1 : 0;

        return res;
    }
}
