package HOT100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HOT51 {
    /*
    N皇后
     */


    ArrayList<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] chessBoard = new char[n][n];
        for (char[] c : chessBoard){
            Arrays.fill(c, '.');
        }

        backTrack(n, 0, chessBoard);

        return res;
    }

    private void backTrack(int n, int row, char[][] chessBoard) {
        if (row == n){
            res.add(Array2List(chessBoard));
            return;
        }

        for (int col = 0;col < n;col++){
            if (isValid(row, col, n, chessBoard)){
                chessBoard[row][col] = 'Q';
                backTrack(n, row + 1, chessBoard);
                chessBoard[row][col] = '.';
            }
        }
    }

    private List<String> Array2List(char[][] chessBoard) {
        List<String> list = new ArrayList<>();

        for (char[] c : chessBoard) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }

    public boolean isValid(int row, int col, int n, char[][] chessboard) {
        // 检查列
        for (int i=0; i<row; ++i) { // 相当于剪枝
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }

        // 检查45度对角线
        for (int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        // 检查135度对角线
        for (int i=row-1, j=col+1; i>=0 && j<=n-1; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
