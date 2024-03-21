package rating1500_1700;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class G1376 {
    /*
    通知所有员工所需的时间
     */

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<Integer> g[] = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 0; i < n; ++i)
            if (manager[i] >= 0)
                g[manager[i]].add(i); // 建树
        return dfs(g, informTime, headID); // 从根节点 headID 开始递归
    }

    private int dfs(List<Integer>[] g, int[] informTime, int x) {
        int maxPathSum = 0;
        for (int y : g[x]) // 遍历 x 的儿子 y（如果没有儿子就不会进入循环）
            maxPathSum = Math.max(maxPathSum, dfs(g, informTime, y));
        // 这和 104 题代码中的 return max(lDepth, rDepth) + 1; 是一个意思
        return maxPathSum + informTime[x];
    }
}
