package rating1500_1700;

import org.junit.Test;

import java.util.Arrays;

public class G2770 {
    /*
    达到末尾下标所需的最大条跳跃次数
     */

    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (Math.abs(nums[i] - nums[j]) <= target) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n - 1] >= 0 ? dp[n - 1] : -1;
    }

    @Test
    public void test(){
        System.out.println(maximumJumps(new int[]{1,3,6,4,1,2},2));
    }
}
