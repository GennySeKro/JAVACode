package Leetcode.week.week455;

import java.util.ArrayList;

public class Q3 {
    /*
    使叶子路径成本相等的最小增量
     */

    public int minIncrease(int n, int[][] edges, int[] cost) {
        ArrayList[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges){
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        int[] res = {0};
        path(0, -1, graph, cost, res);
        return res[0];
    }

    private long path(int cur, int pre, ArrayList<Integer>[] graph, int[] cost, int[] res) {
        long max = 0L;
        int maxCount = 0, total = 0;
        //遍历所有子节点
        for (int ne : graph[cur]){
            if (ne != pre){
                long tmp = path(ne, cur, graph, cost, res);
                total++;
                if (tmp == max){
                    maxCount++;
                } else if (tmp > max) {
                    max = tmp;
                    maxCount = 1;
                }
            }
        }

        if (total != maxCount){
            res[0] += total - maxCount;
        }

        return max + cost[cur];
    }
}
