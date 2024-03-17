package LCR;
import org.junit.Test;

import java.util.*;

public class LCR083 {
    /*
    全排列
     */

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        backTrack(nums, 0, visited);
        return res;
    }

    private void backTrack(int[] nums, int index, boolean[] visited) {
        if (path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0;i < nums.length;i++){
            if (!visited[i]){
                path.add(nums[i]);
                visited[i] = true;
                backTrack(nums, i + 1, visited);
                visited[i] = false;
                path.removeLast();
            }
        }
    }

    @Test
    public void test(){
        System.out.println(permute(new int[]{1,2,3}));
    }
}
