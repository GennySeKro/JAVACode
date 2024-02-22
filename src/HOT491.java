import org.junit.Test;

import java.util.*;

public class HOT491 {
    /*
    非递减子序列
     */

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(nums,0);
        return res;
    }

    private void dfs(int[] nums, int index) {
        if(path.size() > 1){
            res.add(new ArrayList<>(path));
        }
        HashSet<Integer> hs = new HashSet<>();
        for(int i = index;i < nums.length;i++){
            if(!path.isEmpty() && path.getLast() > nums[i] || hs.contains(nums[i])){
               continue;
            }
            if(i > index && nums[i-1] == nums[i]){
                continue;
            }
            hs.add(nums[i]);
            path.add(nums[i]);
            dfs(nums,i + 1);
            path.removeLast();
        }
    }

    @Test
    public void test(){
        System.out.println(findSubsequences(new int[]{1,10,1,1,}));
    }
}
