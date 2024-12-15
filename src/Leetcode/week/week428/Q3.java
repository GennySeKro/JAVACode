package Leetcode.week.week428;

import org.junit.Test;

import java.util.Arrays;

public class Q3 {
    /*
    统计数组中的美丽分割
     */

    public int beautifulSplits(int[] nums) {
        int n = nums.length;
        // lcp[i][j] 表示 s[i:] 和 s[j:] 的最长公共前缀
        int[][] lcp = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= i; j--) {
                if (nums[i] == nums[j]) {
                    lcp[i][j] = lcp[i + 1][j + 1] + 1;
                }
            }
        }

        int ans = 0;
        for (int i = 1; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (i <= j - i && lcp[0][i] >= i ||
                        j - i <= n - j && lcp[i][j] >= j - i) {
                    ans++;
                }
            }
        }
        return ans;
    }

    @Test
    public void test(){
        System.out.println(beautifulSplits(new int[]{2,3,2,2,1}));
    }
}
