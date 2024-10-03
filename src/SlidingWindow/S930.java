package SlidingWindow;

import org.junit.Test;

import java.util.HashMap;

public class S930 {
    /*
    和相同的二元子数组
     */

    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0, sum = 0;

        for (int num : nums){
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            sum += num;
            res += map.getOrDefault(sum - goal, 0);
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(numSubarraysWithSum(new int[]{1,0,1,0,1}, 2));
    }
}
