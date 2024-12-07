package HOT100;

import java.util.ArrayList;
import java.util.List;

public class HOT54 {
    /*
    螺旋矩阵
     */

    public List<Integer> spiralOrder(int[][] matrix) {

        ArrayList<Integer> res = new ArrayList<>();
        int l = 0, u = 0;
        int d = matrix.length - 1, r = matrix[0].length - 1;
        while (true){
            for (int i = l; i <= r; i++){
                res.add(matrix[u][i]);
            }
            if (++u > d){
                break;
            }
            for (int i = u; i <= d; i++){
                res.add(matrix[i][r]);
            }
            if (--r < l){
                break;
            }
            for (int i = r;i >= l;i--){
                res.add(matrix[d][i]);
            }
            if (--d < u){
                break;
            }
            for (int i = d; i >= u; i--){
                res.add(matrix[i][l]);
            }
            if (++l > r){
                break;
            }
        }
        return res;
    }
}
