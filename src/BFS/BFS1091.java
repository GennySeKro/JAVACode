package BFS;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

public class BFS1091 {
    /*
    二进制矩阵中的最短路径
     */


    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1){
            return -1;
        }

        int[][] direction = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1}};
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        grid[0][0] = 1;
        while (!queue.isEmpty()){
            int[] temp = queue.poll();
            if (temp[0] == grid.length - 1 && temp[1] == grid[0].length - 1){
                return grid[temp[0]][temp[1]];
            }

            for (int i = 0;i < 8;i++){
                int x = temp[0] + direction[i][0], y = temp[1] + direction[i][1];
                if (x >= 0 && y >= 0 && x <= grid.length - 1 && y <= grid[0].length - 1 && grid[x][y] == 0){
                    queue.offer(new int[]{x, y});
                    grid[x][y] = grid[temp[0]][temp[1]] + 1;
                }
            }
        }

        return -1;
    }

    @Test
    public void test(){
        System.out.println(shortestPathBinaryMatrix(new int[][]{{0,1}, {1,0}}));
    }
}
