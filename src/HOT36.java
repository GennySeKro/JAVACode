import org.junit.Test;

public class HOT36 {
    /*
    有效的数独
     */

    public boolean isValidSudoku(char[][] board) {
        //记录一个3*3内出现的数字次数
        int[][][] res = new int[3][3][9];
        //记录一列内出现的数字次数
        int[][] col = new int[9][9];
        for (int i = 0;i < 9;i++){
            //记录一行内出现的数字次数
            int[] row = new int[9];
            for (int j = 0;j < 9;j++){
                if (board[i][j] != '.'){
                    row[board[i][j] - '0' - 1]++;
                    col[j][board[i][j] - '0' - 1]++;
                    res[i/3][j/3][board[i][j] - '0' - 1]++;
                    if (res[i/3][j/3][board[i][j] - '0' - 1] > 1 || row[board[i][j] - '0' - 1] > 1 || col[j][board[i][j] - '0' - 1] > 1){
                        return false;
                    }
                }
            }
        }
        return true;
    }


    @Test
    public void test(){
        System.out.println(isValidSudoku(new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'.','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        }));
    }
}
