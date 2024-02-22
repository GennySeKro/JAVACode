import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class HOT40 {
    /*
    组合总和Ⅱ
     */

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates,target,result,path,0);
        return result;
    }

    private void backtracking(int[] candidates, int target, List<List<Integer>> result, LinkedList<Integer> path, int index) {
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = index; i < candidates.length;i++){
            if(candidates[i] > target){
                continue;
            }
            if(i > index && candidates[i] == candidates[i-1]){
                continue;
            }
            path.add(candidates[i]);
            backtracking(candidates, target - candidates[i],result,path,i + 1);
            path.removeLast();
        }
    }


    @Test
    public void test(){
        System.out.println(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5},8));
    }
}
