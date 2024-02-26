package LCR;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LCR080 {
    /*
    组合
     */

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        backTrack(n ,k, 1);
        return res;
    }

    private void backTrack(int n, int k, int index) {
        if (path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index;i <= n - (k - path.size()) + 1;i++){
            path.add(i);
            backTrack(n, k, i + 1);
            path.removeLast();
        }
    }

    @Test
    public void test(){
        System.out.println(combine(4, 2));
    }
}
