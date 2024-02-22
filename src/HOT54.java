import java.util.*;

public class HOT54 {
    /*
    螺旋矩阵
     */

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return ans;

        int u = 0, d = matrix.length - 1;
        int l = 0, r = matrix[0].length - 1;

        while (true) {
            for (int i = l; i <= r; i++) { // 左->右
                ans.add(matrix[u][i]);
            }
            if (++u > d) break;
            for (int i = u; i <= d; i++) { // 上->下
                ans.add(matrix[i][r]);
            }
            if (--r < l) break;
            for (int i = r; i >= l; i--) { // 右->左
                ans.add(matrix[d][i]);
            }
            if (--d < u) break;
            for (int i = d; i >= u; i--) { // 下->上
                ans.add(matrix[i][l]);
            }
            if (++l > r) break;
        }
        return ans;
    }
}
