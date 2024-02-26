package HOT;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HOT77 {
    /*
    组合
     */

    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtracking(n,k,1);
        return res;
    }

    private void backtracking(int n, int k, int index) {
        if(path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = index;i <= n - (k - path.size()) + 1; i ++){
            path.add(i);
            backtracking(n,k,i + 1);
            path.removeLast();
        }
    }


    @Test
    public void test(){
        System.out.println(combine(4,2));
    }
}
