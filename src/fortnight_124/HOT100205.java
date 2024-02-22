package fortnight_124;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HOT100205 {
    /*
    修改数组后最大化数组中的连续元素数目
     */

    public int maxSelectedElements(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        Map<Integer, Integer> dp = new HashMap<>();

        for (int i = n - 1; i >= 0; --i) {
            //nums[i]不选择加一
            dp.put(nums[i], Math.max(dp.getOrDefault(nums[i], 0), 1 + dp.getOrDefault(nums[i] + 1, 0)));
            //nums[i]选择加一
            dp.put(nums[i] + 1, Math.max(dp.getOrDefault(nums[i] + 1, 0), 1 + dp.getOrDefault(nums[i] + 2, 0)));
        }

        int rst = 0;
        for (int val : dp.values()) {
            rst = Math.max(rst, val);
        }
        return rst;
    }

    @Test
    public void test(){
        System.out.println(maxSelectedElements(new int[]{2,1,5,1,1}));
    }
}
