import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HOT78 {
    /*
    子集
    A回溯
     */

    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> subsets(int[] nums){
        dfs(0, nums);
        return res;
    }

    private void dfs(int index, int[] nums) {
        res.add(new ArrayList<>(path));
        if(index >= nums.length){
            return;
        }
        for(int i = index;i < nums.length;i++){
            path.add(nums[i]);
            dfs(i+1,nums);
            path.removeLast();
        }
    }

    /*
    动态规划
    dp[i]表示前i个数的解集，dp[i] = dp[i - 1] + collections(i)。
    其中，collections(i)表示把dp[i-1]的所有子集都加上第i个数形成的子集。
     */
    public List<List<Integer>> subsets1(int[] nums){
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<Integer>());

        for(int i = 0;i<nums.length;i++){
            int size = lists.size();
            for(int j = 0;j<size;j++){
                List<Integer> newList = new ArrayList<>(lists.get(j));
                newList.add(nums[i]);
                lists.add(newList);
            }
        }

        return lists;
    }


}
