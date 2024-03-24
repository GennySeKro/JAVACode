package rating1500_1700;

public class G2684 {
    /*
    矩阵中移动的最大次数
     */

    public int maxMoves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int cur = grid[j][n - i - 1];
                if (cur < grid[j][n - i]) {
                    dp[j][i] = dp[j][i - 1] + 1;
                }

                if (j - 1 >= 0 && cur < grid[j - 1][n - i]) {
                    dp[j][i] = Math.max(dp[j][i], dp[j - 1][i - 1] + 1);
                }

                if (j + 1 < m && cur < grid[j + 1][n - i]) {
                    dp[j][i] = Math.max(dp[j][i], dp[j + 1][i - 1] + 1);
                }
            }
        }

        int ans = 0;
        for (int k = 0; k < m; k++) {
            ans = Math.max(ans, dp[k][n - 1]);
        }

        return ans;
    }
}
