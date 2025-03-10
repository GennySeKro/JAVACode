package monotoneStack;

import java.util.ArrayDeque;

public class mS1793 {
    /*
    好子数组的最大分数
     */

    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int ans = nums[k], minH = nums[k];
        int i = k, j = k;
        for (int t = 0; t < n - 1; t++) { // 循环 n-1 次
            if (j == n - 1 || i > 0 && nums[i - 1] > nums[j + 1]) {
                minH = Math.min(minH, nums[--i]);
            } else {
                minH = Math.min(minH, nums[++j]);
            }
            ans = Math.max(ans, minH * (j - i + 1));
        }
        return ans;
    }
}
