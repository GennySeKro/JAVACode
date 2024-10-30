package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class BFS1926 {
    /*
    迷宫中离入口最近的出口
     */

    private static final int directions[][] = {{1,0},{-1,0},{0,1},{0,-1}}; // 转移的四个方向

    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length, n = maze[0].length;
        maze[entrance[0]][entrance[1]] = '+';       // 将起点标记为墙，表示不可访问
        int start = entrance[0] * n + entrance[1];  // 将起点坐标转为一个int编号
        Queue<int[]> qu = new LinkedList<>();       // 队列存储某个位置的坐标编号和到达这个坐标的步数
        qu.offer(new int[]{start, 0});              // 初始化队列，将起点入队
        while(!qu.isEmpty()){
            int[] front = qu.poll();                                  // 获取队首节点信息
            int r = front[0] / n, c = front[0] % n, d = front[1];     // 将坐标编号转为坐标(r,c)
            for(int[] direct: directions){
                int nextR = r + direct[0], nextC = c + direct[1];     // 往四个方向转移，即下一步到达的坐标
                if(nextR == -1 || nextR == m || nextC == -1 || nextC == n || maze[nextR][nextC] == '+')continue;    // 跳过不合法的坐标
                if(nextR == 0 || nextR == m - 1 || nextC == 0 || nextC == n - 1){
                    return d+1;                                       // 合法坐标且下一步到达出口，返回结果
                }
                int nextPos = nextR * n + nextC;    // 生成下一个坐标的编号
                qu.offer(new int[]{nextPos, d+1});  // 将下一个坐标信息加入队列
                maze[nextR][nextC] = '+';           // 入队即为已访问，将这个坐标标为墙
            }
        }
        return -1;                                  // 不能到达出口，返回-1
    }

}
