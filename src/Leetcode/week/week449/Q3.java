package Leetcode.week.week449;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q3 {
    /*
    图中边值的最大和
     */

    public long maxScore(int n, int[][] edges) {
        ArrayList<List<Integer>> graph = new ArrayList<>();
        for (int i = 0;i < n; i++){
            graph.add(new ArrayList<>());
        }

        for (int[] e : edges){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        ArrayList<Integer> cycle = new ArrayList<>();
        ArrayList<Integer> noCycle = new ArrayList<>();

        boolean[] isVisited = new boolean[n];
        for (int i = 0; i < n; i++){
            if (graph.get(i).size() == 1 && !isVisited[i]){
                //处理非环节点，实际上是处理了度为1的边缘节点？
                noCycle.add(dfs(i, -1, graph, isVisited));
            }
        }

        for (int i = 0;i < n; i++){
            if (graph.get(i).size() == 2 && !isVisited[i]){
                //处理环节点，实际上是处理了度为2的节点
                cycle.add(dfs(i, -1, graph, isVisited));
            }
        }

        Collections.sort(cycle);
        Collections.sort(noCycle);

        int[] max = {n};
        long res = 0L;

        for (int c : cycle){
            res += cycleCal(c, max);
        }
        for (int c : noCycle){
            res += noCycleCal(c, max);
        }

        return res;
    }

    //深度优先搜索，计算当前节点的子树大小
    private int dfs(int cur, int pre, ArrayList<List<Integer>> graph, boolean[] isVisited){
        if (isVisited[cur]){
            return 0;
        }

        isVisited[cur] = true;
        int res = 1;
        for (int n : graph.get(cur)){
            if (n != pre){
                res += dfs(n, cur, graph, isVisited);
                break;
            }
        }

        return res;
    }

    private long cycleCal(int c, int[] max) {
        // 计算环节点得分
        long st = max[0];
        max[0] -= c;
        c -= 1;
        long res = 0;
        long[] tmp = {st, -1};
        while (c > 1) {
            if (tmp[1] == -1) {
                res += st * (st - 1);
                res += st * (st - 2);
                tmp[0] = st - 1;
                tmp[1] = st - 2;
            } else {
                res += tmp[0] * (tmp[1] - 1);
                res += tmp[1] * (tmp[1] - 2);
                tmp[0] = tmp[1] - 1;
                tmp[1] = tmp[1] - 2;
            }
            c -= 2;
        }
        if (c == 0) {
            res += tmp[0] * tmp[1];
        } else {
            res += tmp[0] * (tmp[1] - 1);
            res += tmp[1] * (tmp[1] - 1);
        }
        return res;
    }

    // 辅助函数：计算非环节点的得分
    private long noCycleCal(int c, int[] max) {
        // 计算非环节点得分
        long st = max[0];
        max[0] -= c;
        c -= 2;
        long res = st * (st - 1);
        long[] tmp = {st, st - 1};
        while (c > 1) {
            res += tmp[0] * (tmp[1] - 1);
            res += tmp[1] * (tmp[1] - 2);
            tmp[0] = tmp[1] - 1;
            tmp[1] = tmp[1] - 2;
            c -= 2;
        }
        if (c == 1) {
            res += tmp[0] * (tmp[1] - 1);
        }
        return res;
    }
}
