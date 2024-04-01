package Leetcode.fortnight.f127;

import org.junit.Test;

public class HOT100272 {
    /*
    或值至少k的最短子数组Ⅰ
     */

    public int minimumSubarrayLength(int[] nums, int k) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0;i < nums.length;i++){
            int sum = 0;
            for (int j = i;j < nums.length;j++){
                sum = sum | nums[j];
                if (sum >= k){
                    ans = Math.min(ans, j - i + 1);
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    @Test
    public void test(){
        System.out.println(minimumSubarrayLength(new int[]{1,2}, 0));
    }
}
