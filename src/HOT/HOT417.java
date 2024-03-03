package HOT;
import java.util.*;

public class HOT417 {
    /*
    太平洋大西洋水流问题
     */

    /*
    深度优先遍历
    时间复杂度O(n * m)
    空间复杂度O(n * m)
     */
    class one{
        private static final int[][] position = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            int rowSize = heights.length, colSize = heights[0].length;
            List<List<Integer>> ans = new ArrayList<>();
            // 记录 [row, col] 位置是否可以到某条河，可以为 true，反之为 false；
            // 假设太平洋的标记为 1，大西洋为 0
            boolean[][][] visited = new boolean[rowSize][colSize][2];
            for (int row = 0; row < rowSize; row++) {
                visited[row][colSize - 1][0] = true;
                visited[row][0][1] = true;
                dfs(heights, row, colSize - 1, 0, visited);
                dfs(heights, row, 0, 1, visited);
            }
            for (int col = 0; col < colSize; col++) {
                visited[rowSize - 1][col][0] = true;
                visited[0][col][1] = true;
                dfs(heights, rowSize - 1, col, 0, visited);
                dfs(heights, 0, col, 1, visited);
            }
            for (int row = 0; row < rowSize; row++) {
                for (int col = 0; col < colSize; col++) {
                    // 如果该位置即可以到太平洋又可以到大西洋，就放入答案数组
                    if (visited[row][col][0] && visited[row][col][1])
                        ans.add(List.of(row, col));
                }
            }
            return ans;
        }

        private void dfs(int[][] heights, int row, int col, int sign, boolean[][][] visited) {
            for (int[] current: position){
                int curRow = row + current[0], curCol = col + current[1];
                if (curRow < 0 || curRow >= heights.length || curCol < 0 || curCol >= heights[0].length){
                    continue;
                }
                if (heights[curRow][curCol] < heights[row][col] || visited[curRow][curCol][sign]) {
                    continue;
                }
                visited[curRow][curCol][sign] = true;
                dfs(heights, curRow, curCol, sign, visited);
            }
        }
    }

    /*
    广度优先
     */
    class two{
        private static final int[][] position = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        public List<List<Integer>> pacificAtlantic(int[][] heights){
            int rowSize = heights.length, colSize = heights[0].length;
            List<List<Integer>> ans = new ArrayList<>();
            boolean[][][] visited = new boolean[rowSize][colSize][2];
            // 队列，保存的数据为 [行号, 列号, 标记]
            // 假设太平洋的标记为 1，大西洋为 0
            Queue<int[]> queue = new ArrayDeque<>();
            for (int row = 0; row < rowSize; row++) {
                visited[row][colSize - 1][0] = true;
                visited[row][0][1] = true;
                queue.add(new int[]{row, colSize - 1, 0});
                queue.add(new int[]{row, 0, 1});
            }
            for (int col = 0; col < colSize; col++) {
                visited[rowSize - 1][col][0] = true;
                visited[0][col][1] = true;
                queue.add(new int[]{rowSize - 1, col, 0});
                queue.add(new int[]{0, col, 1});
            }
            bfs(heights, queue, visited);
            for (int row = 0; row < rowSize; row++) {
                for (int col = 0; col < colSize; col++) {
                    // 如果该位置即可以到太平洋又可以到大西洋，就放入答案数组
                    if (visited[row][col][0] && visited[row][col][1])
                        ans.add(List.of(row, col));
                }
            }
            return ans;
        }

        private void bfs(int[][] heights, Queue<int[]> queue, boolean[][][] visited) {
            while (!queue.isEmpty()) {
                int[] curPos = queue.poll();
                for (int[] current: position) {
                    int row = curPos[0] + current[0], col = curPos[1] + current[1], sign = curPos[2];
                    // 越界
                    if (row < 0 || row >= heights.length || col < 0 || col >= heights[0].length) continue;
                    // 高度不合适或者已经被访问过了
                    if (heights[row][col] < heights[curPos[0]][curPos[1]] || visited[row][col][sign]) continue;
                    visited[row][col][sign] = true;
                    queue.add(new int[]{row, col, sign});
                }
            }
        }
    }
}
