package HOT;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class HOT39 {
    /*
    组合总和
     */

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        Arrays.sort(candidates);
        dfs(candidates,target,res,path,0);
        return res;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> res, LinkedList<Integer> path, int index) {
        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }else if (target < 0){
            return;
        }
        for(int i = index;i < candidates.length;i++){
            if (candidates[i] > target) {
                continue;
            }
            path.add(candidates[i]);
            dfs(candidates,target-candidates[i],res,path,index++);
            path.removeLast();
        }
    }

    @Test
    public void test(){
        System.out.println(combinationSum(new int[]{8, 2, 6, 3},13));
    }
}
