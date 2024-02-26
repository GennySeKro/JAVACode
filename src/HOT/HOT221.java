package HOT;

public class HOT221 {
    /*
    最大正方形
    暴力:时间复杂度O(mn * min(m,n) * min(m,n))
        空间复杂度O(1)
     */

    public int maximalSquare(char[][] matrix) {
       int maxSide = 0;
       if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
           return maxSide;
       }

       int rows = matrix.length, colums = matrix[0].length;
       for(int i = 0;i < rows;i++){
           for(int j = 0;j < colums;j++){
               if(matrix[i][j] == '1'){
                   maxSide = Math.max(maxSide,1);

                   int currentMaxSide = Math.min(rows-i,colums-j);
                   for(int k = 1;k < currentMaxSide;k++){
                       boolean flag = true;
                       if(matrix[i+k][j+k] == '0'){
                           break;
                       }
                       for(int m = 0;m < k;m++){
                           if(matrix[i+k][j+m] == '0' || matrix[i+m][j+k] == '0' ){
                               flag = false;
                               break;
                           }
                       }
                       if(flag){
                           maxSide = Math.max(maxSide,k+1);
                       }else break;;
                   }
               }
           }
       }
       return maxSide*maxSide;
    }

    /*
    动态规划
    时间复杂度O(nm)
    空间复杂度O(nm)
     */
    public int maximalSquare1(char[][] matrix){
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return maxSide;
        }

        int rows = matrix.length, colums = matrix[0].length;
        int[][] dp = new int[rows][colums];
        for(int i = 0;i < rows;i++){
            for(int j = 0;j < colums;j++){
                if(matrix[i][j] == '1'){
                    if(i == 0 || j == 0){
                        dp[i][j] = 1;
                    }else {
                        dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i-1][j-1]),dp[i][j-1]) + 1;
                    }
                    maxSide = Math.max(maxSide,dp[i][j]);
                }
            }
        }
        return maxSide*maxSide;
    }

}
