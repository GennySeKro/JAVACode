package LCR;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LCR104 {
    /*
    组合总和Ⅳ
     */

    /*
    回溯：超时
     */
    class one{
        int res = 0;
        List<List<Integer>> list = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        public int combinationSum4(int[] nums, int target) {
            trackBack(nums, 0, target);
            return res;
        }

        private void trackBack(int[] nums, int index, int target) {
            if (target == 0){
                res++;
                list.add(new ArrayList<>(path));
                return;
            }
            if (target < 0){
                return;
            }
            for (int i = index;i < nums.length;i++){
                path.add(nums[i]);
                trackBack(nums, 0, target - nums[i]);
                path.removeLast();
            }
        }
    }


    /*
    动态规划
     */
    class two{
        public int combinationSum4(int[] nums, int target){
            int[] dp = new int[target + 1];
            dp[0] = 1;
            for(int i = 1; i <= target; ++i) {
                for(int num : nums) {
                    if(i >= num) {
                        dp[i] += dp[i - num];
                    }
                }
            }
            return dp[target];
        }
    }

    @Test
    public void test(){
        System.out.println(new two().combinationSum4(new int[]{4,2,1}, 32));
    }
}
