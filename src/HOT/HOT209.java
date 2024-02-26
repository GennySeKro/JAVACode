package HOT;

import org.junit.Test;

import java.util.Arrays;

public class HOT209 {
    /*
    长度最小的子数组
     */

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    @Test
    public void test(){
        System.out.println(minSubArrayLen(213,new int[]{12,28,83,4,25,26,25,2,25,25,25,12}));
    }
}
