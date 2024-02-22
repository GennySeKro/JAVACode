public class HOT240 {
    /*
    搜索二维矩阵Ⅱ
    时间复杂度O(m+n)、空间复杂度O(1)
     */

    public boolean searchMatrix(int[][] matrix, int target) {
       int m = matrix.length, n = matrix[0].length;
       int x = 0, y = n - 1;

       while(x < m && y >= 0){
           if(matrix[x][y] == target){
               return true;
           }
           if(matrix[x][y] > target){
               y--;
           }else {
               x++;
           }
       }
       return false;
    }
}
