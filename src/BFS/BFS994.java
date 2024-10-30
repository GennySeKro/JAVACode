package BFS;

import java.util.ArrayDeque;
import java.util.Deque;

public class BFS994 {
    /*
    腐烂的橘子
     */

    public int orangesRotting(int[][] grid) {
        int freshNum = 0;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        for (int i = 0;i < grid.length;i++){
            for (int j = 0;j < grid[0].length;j++){
                if (grid[i][j] == 1){
                    freshNum++;
                } else if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int res = 0;
        while (!queue.isEmpty()){
            if (freshNum == 0){
                return res;
            }
            res++;
            int tempLen = queue.size();
            for (int i = 0;i < tempLen;i++){
                int[] tempIndex = queue.poll();
                freshNum -= BFS(grid, tempIndex[0] - 1, tempIndex[1], queue);
                freshNum -= BFS(grid, tempIndex[0], tempIndex[1] + 1, queue);
                freshNum -= BFS(grid, tempIndex[0] + 1, tempIndex[1], queue);
                freshNum -= BFS(grid, tempIndex[0], tempIndex[1] - 1, queue);
            }
        }
        return freshNum > 0 ? -1 : res;
    }

    private int BFS(int[][] grid, int i, int j, ArrayDeque<int[]> queue) {
        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1 || grid[i][j] != 1){
            return 0;
        }

        grid[i][j] = 2;
        queue.offer(new int[]{i, j});
        return 1;
    }
}
