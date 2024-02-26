package HOT;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HOT216 {
    /*
    组合总和Ⅲ
     */

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k,n,path,res,1);
        return res;
    }

    private void backtracking(int k, int target, LinkedList<Integer> path, List<List<Integer>> res, int index) {
        if(path.size() == k && target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index;i <= 9 - (k-path.size())+1;i++){
            if(i > target){
                return;
            }
            path.add(i);
            backtracking(k,target-i,path,res,i+1);
            path.removeLast();
        }
    }

    @Test
    public void test(){
        System.out.println(combinationSum3(9,45));
    }
}
