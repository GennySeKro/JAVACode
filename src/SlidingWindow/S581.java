package SlidingWindow;

import org.junit.Test;

public class S581 {
    /*
    最短无序连续子数组
     */

    public int findUnsortedSubarray(int[] nums) {
        // 初始化
        int len = nums.length;
        int min = nums[len - 1];
        int max = nums[0];
        int begin = 0, end = -1;
        for (int i = 0; i < len; i++) {
            if (nums[i] < max) {      // 从左到右维持最大值，寻找右边界end
                end = i;
            } else {
                max = nums[i];
            }
        }
        for (int i = len - 1; i >= 0; i--) {
            if (nums[i] > min) {    // 从右到左维持最小值，寻找左边界begin
                begin = i;
            } else {
                min = nums[i];
            }
        }
        return end - begin + 1;
    }


    @Test
    public void test(){
        System.out.println(findUnsortedSubarray(new int[]{1,3,2,2,2}));
    }
}
