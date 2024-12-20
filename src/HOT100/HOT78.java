package HOT100;

import java.util.*;

public class HOT78 {
    /*
    子集
     */

    ArrayList<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> temp = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        res.add(new ArrayList<>());
        backTrack(nums, 0);
        return res;
    }

    private void backTrack(int[] nums, int index) {
        for (int i = index;i < nums.length;i++){
            temp.add(nums[i]);
            res.add(new ArrayList<>(temp));
            backTrack(nums, i + 1);
            temp.removeLast();
        }
    }
}
