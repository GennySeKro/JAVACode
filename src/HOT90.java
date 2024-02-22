import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class HOT90 {
    /*
    子集Ⅱ
     */


    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backTrack(nums,0);
        return res;
    }

    private void backTrack(int[] nums, int index) {
        res.add(new ArrayList<>(path));
        for(int i = index;i < nums.length;i++){
            if ( i > index && nums[i - 1] == nums[i] ) {
                continue;
            }
            path.add(nums[i]);
            backTrack(nums,i+1);
            path.removeLast();
        }
    }

    @Test
    public void test(){
        System.out.println(subsetsWithDup(new int[]{1, 2, 2}));
    }
}
