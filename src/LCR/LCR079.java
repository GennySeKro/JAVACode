package LCR;
import java.util.*;

public class LCR079 {
    /*
    子集
     */

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backTrck(nums, 0);
        return res;
    }

    private void backTrck(int[] nums, int index) {
        res.add(new ArrayList<>(path));
        for (int i = index;i < nums.length;i++){
            path.add(nums[i]);
            backTrck(nums, i + 1);
            path.removeLast();
        }
    }
}
