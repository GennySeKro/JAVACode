package HOT;

public class HOT74 {
    /*
    搜索二维矩阵
     */

    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0;i < matrix.length;i++){
            if (matrix[i][0] <= target && matrix[i][matrix[0].length - 1] >= target){
                for (int j = 0;j < matrix[0].length;j++){
                    if (matrix[i][j] == target){
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }
}
