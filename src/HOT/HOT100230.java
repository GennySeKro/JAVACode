package HOT;

import org.junit.Test;

import java.util.Arrays;

public class HOT100230 {
    /*
    修改矩阵
     */

    public int[][] modifiedMatrix(int[][] matrix) {
        int[] maxRow = new int[matrix[0].length];
        int[][] res = new int[matrix.length][matrix[0].length];
        Arrays.fill(maxRow, -1);
        for (int i = 0;i < matrix.length;i++){
            for (int j = 0;j < matrix[0].length;j++){
                if (matrix[i][j] == -1){
                    if (maxRow[j] == -1){
                        for(int k = 0;k < matrix.length;k++){
                            maxRow[j] = Math.max(maxRow[j], matrix[k][j]);
                        }
                        res[i][j] = maxRow[j];
                    }else {
                        res[i][j] = maxRow[j];
                    }
                }else {
                    res[i][j] = matrix[i][j];
                }
            }
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(Arrays.deepToString(modifiedMatrix(new int[][]{{1, 2, -1}, {4, -1, 6}, {7, 8, 9}})));
    }
}
