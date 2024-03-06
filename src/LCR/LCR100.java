package LCR;
import java.util.*;

public class LCR100 {
    /*
    三角形最小路径和
     */

    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        List<Integer> lastRow = triangle.get(triangle.size() - 1);
        for (int i = 0; i < triangle.size(); i++) {
            dp[triangle.size() - 1][i] = lastRow.get(i);
        }

        for (int i = triangle.size() - 2; i >= 0; i--) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                dp[i][j] = row.get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }

        return dp[0][0];
    }
}
