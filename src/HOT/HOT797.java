package HOT;
import java.util.*;

public class HOT797 {
    /*
    所有可能的路径
     */

    List<List<Integer>> res;
    List<Integer> path;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        path.add(0);
        dfs(graph, 0);
        return res;
    }

    private void dfs(int[][] graph, int node) {
        if (node == graph.length - 1){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0;i < graph[i].length;i++){
            int nextNode = graph[node][i];
            path.add(nextNode);
            dfs(graph, nextNode);
            path.remove(path.size() - 1);
        }
    }
}
