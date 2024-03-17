package LCR;
import org.junit.Test;

import java.util.*;

public class LCR082 {
    /*
    组合总和Ⅱ
     */

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        bacjTrack(candidates, 0, target);
        return res;
    }

    private void bacjTrack(int[] candidates, int index, int target) {
        if (target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        if (target < 0){
            return;
        }
        for (int i = index;i < candidates.length;i++){
            if (i != index && candidates[i] == candidates[i - 1]){
                continue;
            }
            path.add(candidates[i]);
            bacjTrack(candidates, i + 1, target - candidates[i]);
            path.removeLast();
        }
    }

    @Test
    public void test(){
        System.out.println(combinationSum2(new int[]{10,1,2,7,6,1,5,1}, 8));
    }
}
