package HOT;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HOT46 {
    /*
    全排列
     */

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        dfs(nums);
        return res;
    }

    private void dfs(int[] nums) {
       if(path.size() == nums.length){
           res.add(new ArrayList<>(path));
       }
       for(int i = 0;i < nums.length;i++){
           if(used[i]){
               continue;
           }
           used[i] = true;
           path.add(nums[i]);
           dfs(nums);
           path.removeLast();
           used[i] = false;
       }
    }

    @Test
    public void test(){
        System.out.println(permute(new int[]{1, 2, 3}));
    }

}
