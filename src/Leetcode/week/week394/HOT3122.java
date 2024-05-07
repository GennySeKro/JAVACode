package Leetcode.week.week394;

import java.util.Arrays;

public class HOT3122 {
    /*
    使矩阵满足条件的最少操作次数
     */

    public int minimumOperations(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] cnt = new int[n][10];
        for (int[] row : grid) {
            for (int j = 0; j < n; j++) {
                cnt[j][row[j]]++;
            }
        }
        int[][] memo = new int[n][11];
        for (int[] row : memo) {
            Arrays.fill(row, -1); // -1 表示没有计算过
        }
        return m * n - dfs(n - 1, 10, cnt, memo);
    }

    private int dfs(int i, int j, int[][] cnt, int[][] memo) {
        if (i < 0) {
            return 0;
        }
        if (memo[i][j] != -1) { // 之前计算过
            return memo[i][j];
        }
        int res = 0;
        for (int k = 0; k < 10; ++k) {
            if (k != j) {
                res = Math.max(res, dfs(i - 1, k, cnt, memo) + cnt[i][k]);
            }
        }
        return memo[i][j] = res; // 记忆化
    }
}
