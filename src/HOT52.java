import java.util.Arrays;


public class HOT52 {
    /*
    N皇后Ⅱ
     */

    int res = 0;
    public int totalNQueens(int n) {
        char[][] matrix = new char[n][n];
        for (char[] row : matrix){
            Arrays.fill(row, '.');
        }
        backTrack(n, 0, matrix);
        return res;

    }

    private void backTrack(int n, int row, char[][] matrix) {
        if (row == n){
            res++;
            return;
        }

        for (int col = 0;col < n;col++){
            if (isValid(row, col, matrix, n)){
                matrix[row][col] = 'Q';
                backTrack(n,row + 1, matrix);
                matrix[row][col] = '.';
            }
        }
    }

    public boolean isValid(int row, int col, char[][] matrix, int n) {
        // 检查列
        for (int i=0; i<row; ++i) { // 相当于剪枝
            if (matrix[i][col] == 'Q') {
                return false;
            }
        }

        // 检查45度对角线
        for (int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
            if (matrix[i][j] == 'Q') {
                return false;
            }
        }

        // 检查135度对角线
        for (int i=row-1, j=col+1; i>=0 && j<=n-1; i--, j++) {
            if (matrix[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
