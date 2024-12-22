package HOT100;

import org.junit.Test;

public class HOT74 {
    /*
    搜索二维矩阵
     */

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length, col = matrix[0].length;
        for (int i = 0;i < row;i++){
            if (matrix[i][0] <= target && matrix[i][col - 1] >= target){
                int left = 0, right = col - 1;
                while (left <= right){
                    int mid = left + ((right - left) >> 1);
                    if (matrix[i][mid] == target){
                        return true;
                    }else if (matrix[i][mid] > target){
                        right = mid - 1;
                    }else {
                        left = mid + 1;
                    }
                }
            }
        }

        return false;
    }

    @Test
    public void test(){
        System.out.println(searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 13));
    }
}
