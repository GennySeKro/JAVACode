package LCR;

import org.junit.Test;

import java.util.*;

public class LCR115 {
    /*
    重建序列
     */

    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        /*
        拓扑排序:
        1 <= n <= 1e4
        1 <= sequences[i].length <= 1e4
        1 <= sum(sequences[i].length) <= 1e5
        我们先将seq表示的子序列顺序都保存为一张图，并能统计每一个节点的对应的入度
        要满足题目要求必须满足3个条件:
        1.入度为0的节点只能有1个，否则出来的超序列不唯一
        2.不能成环，否则出来的超序列不唯一
        3.最后入队的节点数=n，否则不能保证超序列最短
        如果全部满足返回true，构造返回false
         */
        int n = nums.length;
        boolean[] vis = new boolean[n + 1];
        List<Integer>[] edges = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }
        // 建图
        for (int[] p : sequences) {
            for (int j = 0; j < p.length - 1; j++) {
                edges[p[j]].add(p[j + 1]);
            }
        }
        int[] inDegree = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (Integer ne : edges[i]) {
                inDegree[ne]++;
            }
        }
        Queue<Integer> que = new LinkedList<>();
        int cnt = 0;    // 统计某一时间入度为0的节点数目
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                que.add(i);
                vis[i] = true;
                cnt++;
            }
            if (cnt > 1) return false;  // >1个节点入度为0返回false
        }
        while (!que.isEmpty()) {
            int p = que.poll(); // 要删除的节点
            cnt = 0;
            for (Integer ne : edges[p]) {
                if (--inDegree[ne] == 0) {
                    que.add(ne);
                    vis[ne] = true;
                    cnt++;
                }
            }
            if (cnt > 1) return false;
        }
        // 检测是否n个节点都入队了
        for (int i = 1; i <= n; i++) {
            if (!vis[i]) return false;
        }
        return true;
    }

    @Test
    public void test(){
        System.out.println(sequenceReconstruction(new int[]{1,2,3}, new int[][]{{1,2},{1,3},{2,3}}));
    }
}
