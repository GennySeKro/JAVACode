package LCR;
import java.util.*;

public class LCR081 {
    /*
    组合总和
     */

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTrack(candidates, 0, target);
        return res;
    }

    private void backTrack(int[] candidates, int index, int target) {
        if (target == 0){
            res.add(new ArrayList<>(path));
            return;
        } else if (target < 0) {
            return;
        }

        for (int i = index;i < candidates.length;i++){
            path.add(candidates[i]);
            backTrack(candidates, i, target - candidates[i]);
            path.removeLast();
        }
    }
}
