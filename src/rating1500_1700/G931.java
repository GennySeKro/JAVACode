package rating1500_1700;

import java.util.Arrays;

public class G931 {
    /*
    下降路径最小和
     */

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        var f = new int[n][n + 2];
        System.arraycopy(matrix[0], 0, f[0], 1, n);
        for (int r = 1; r < n; r++) {
            f[r - 1][0] = f[r - 1][n + 1] = Integer.MAX_VALUE;
            for (int c = 0; c < n; c++)
                f[r][c + 1] = Math.min(Math.min(f[r - 1][c], f[r - 1][c + 1]), f[r - 1][c + 2]) + matrix[r][c];
        }
        int ans = Integer.MAX_VALUE;
        for (int c = 1; c <= n; c++)
            ans = Math.min(ans, f[n - 1][c]);
        return ans;
    }
}
