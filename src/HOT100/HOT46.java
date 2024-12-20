package HOT100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HOT46 {
    /*
    全排列
     */

    ArrayList<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> temp = new LinkedList<>();
    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0){
            return res;
        }
        used = new boolean[nums.length];
        backTrack(nums);
        return res;
    }

    private void backTrack(int[] nums) {
        if (temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0;i < nums.length;i++){
            if (!used[i]){
                used[i] = true;
                temp.add(nums[i]);
                backTrack(nums);
                temp.removeLast();
                used[i] = false;
            }
        }
    }
}
