package BFS;

import java.util.ArrayDeque;
import java.util.Deque;

public class BFS1161 {
    /*
    地图分析
     */

    private int[][] direction = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
    public int maxDistance(int[][] grid) {
        int res = -1;
        for (int i = 0;i < grid.length;i++){
            for (int j = 0;j < grid[0].length;j++){
                if (grid[i][j] == 0){
                    res = Math.max(res, BFS(grid, i, j));
                }
            }
        }

        return res;
    }

    private int BFS(int[][] grid, int i, int j) {
        boolean[][] used = new boolean[grid.length][grid[0].length];
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i, j, 0});
        used[i][j] = true;

        while (!queue.isEmpty()){
            int[] temp = queue.poll();
            for (int k = 0;k < 4;k++){
                int x = temp[0] + direction[k][0];
                int y = temp[1] + direction[k][1];
                if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || used[x][y]){
                    continue;
                }

                if (grid[x][y] == 0){
                    queue.offer(new int[]{x, y, temp[2] + 1});
                    used[x][y] = true;
                }else {
                    return temp[2] + 1;
                }
            }
        }

        return -1;
    }
}
