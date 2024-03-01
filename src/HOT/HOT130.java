package HOT;

public class HOT130 {
    /*
    被围绕的区域
     */

    int[][] dir ={{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public void solve(char[][] board) {

        for(int i = 0; i < board.length; i++){
            if(board[i][0] == 'O') dfs(board, i, 0);
            if(board[i][board[0].length - 1] == 'O') dfs(board, i, board[0].length - 1);
        }

        for(int j = 1 ; j < board[0].length - 1; j++){
            if(board[0][j] == 'O') dfs(board, 0, j);
            if(board[board.length - 1][j] == 'O') dfs(board, board.length - 1, j);
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == 'A') board[i][j] = 'O';
            }
        }
    }

    private void dfs(char[][] board, int x, int y){
        if(board[x][y] == 'X' || board[x][y] == 'A')
            return;
        board[x][y] = 'A';
        for(int i = 0; i < 4; i++){
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];

            if(nextX < 0 || nextY < 0 || nextX >= board.length || nextY >= board[0].length)
                continue;
            dfs(board, nextX, nextY);
        }
    }
}
