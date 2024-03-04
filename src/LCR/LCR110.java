package LCR;
import java.util.*;

public class LCR110 {
    /*
    所有可能的路径
     */

    List<List<Integer>> res;
    LinkedList<Integer> path;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        res = new ArrayList<>();
        path = new LinkedList<>();
        path.add(0);
        dfs(graph, 0, graph.length - 1);
        return res;
    }

    private void dfs(int[][] graph, int begin, int end) {
        if (begin == end){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0;i < graph[begin].length;i++){
            path.add(graph[begin][i]);
            dfs(graph, graph[begin][i], end);
            path.removeLast();
        }
    }
}
