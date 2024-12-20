package HOT100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HOT39 {
    /*
    组合总和
     */

    private ArrayList<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTrack(candidates, 0, target);
        return res;
    }

    private void backTrack(int[] candidates, int index, int target) {
        if (target < 0){
            return;
        }

        if (target == 0){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index;i < candidates.length;i++){
            path.add(candidates[i]);
            backTrack(candidates, i, target - candidates[i]);
            path.removeLast();
        }
    }
}
