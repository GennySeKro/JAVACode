package SlidingWindow;

import org.junit.Test;

import java.util.Arrays;

public class S2090 {
    /*
    半径为k的子数组平均值
     */

    public int[] getAverages(int[] nums, int k) {
        if (k == 0){
            return nums;
        }

        if (2 * k + 1 > nums.length){
            int[] res = new int[nums.length];
            Arrays.fill(res ,-1);
            return res;
        }

        double tempSum = 0.0;
        int[] res = new int[nums.length];
        for (int i = 0;i <= 2 * k;i++){
            tempSum += nums[i];
        }

        for (int i = 0;i < nums.length;i++){
            if (i < k || i >= nums.length - k){
                res[i] = -1;
            }else {
                res[i] = (int)tempSum / (2 * k + 1);
                if (i + k + 1 < nums.length){
                    tempSum = tempSum - nums[i - k] + nums[i + k + 1];
                }
            }
        }

        return res;
    }

    @Test
    public void test(){
        System.out.println(getAverages(new int[]{7}, 3));
    }
}
