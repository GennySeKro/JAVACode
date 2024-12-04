package HOT100;

import org.junit.Test;

import java.util.HashMap;

public class HOT560 {
    /*
    和为k的子数组
     */

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, res = 0;
        for (int num : nums){
            sum += num;
            res += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return res;
    }

    @Test
    public void test(){
        System.out.println(subarraySum(new int[]{1}, 0));
    }
}
