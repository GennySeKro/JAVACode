package HOT;

import java.util.ArrayDeque;
import java.util.Queue;

public class HOT130 {
    /*
    被包围的区域
     */

    /*
    广度优先
     */

    private static final int[][] position = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};  // 四个方向

    public void solve(char[][] board) {
        // rowSize：行的长度，colSize：列的长度
        int rowSize = board.length, colSize = board[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        // 从左侧边，和右侧边遍历
        for (int row = 0; row < rowSize; row++) {
            if (board[row][0] == 'O')
                queue.add(new int[]{row, 0});
            if (board[row][colSize - 1] == 'O')
                queue.add(new int[]{row, colSize - 1});
        }
        // 从上边和下边遍历，在对左侧边和右侧边遍历时我们已经遍历了矩阵的四个角
        // 所以在遍历上边和下边时可以不用遍历四个角
        for (int col = 1; col < colSize - 1; col++) {
            if (board[0][col] == 'O')
                queue.add(new int[]{0, col});
            if (board[rowSize - 1][col] == 'O')
                queue.add(new int[]{rowSize - 1, col});
        }
        // 广度优先遍历，把没有被 'X' 包围的 'O' 修改成特殊值
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            board[current[0]][current[1]] = 'A';
            for (int[] pos: position) {
                int row = current[0] + pos[0], col = current[1] + pos[1];
                // 如果范围越界、该位置的值不是 'O'，就直接跳过
                if (row < 0 || row >= rowSize || col < 0 || col >= colSize) continue;
                if (board[row][col] != 'O') continue;
                queue.add(new int[]{row, col});
            }
        }
        // 遍历数组，把 'O' 修改成 'X'，特殊值修改成 'O'
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                if (board[row][col] == 'A') board[row][col] = 'O';
                else if (board[row][col] == 'O') board[row][col] = 'X';
            }
        }
    }
}
