package SlidingWindow;

import org.junit.Test;

public class S2962 {
    /*
    统计最大元素出现至少K次的子数组
     */

    public long countSubarrays(int[] nums, int k) {
        long res = 0L;
        int maxValue = 0;
        for (int num : nums){
            maxValue = Math.max(maxValue, num);
        }

        int maxValueNum = 0;
        int left = 0, right = 0;
        while (right < nums.length){
            if (nums[right] == maxValue){
                maxValueNum++;
            }

            while (maxValueNum == k){
                if (nums[left] == maxValue){
                    maxValueNum--;
                }
                left++;
            }
            res += left;
            right++;
        }

        return res;
    }

    @Test
    public void test(){
        System.out.println(countSubarrays(new int[]{1,3,2,3,3}, 2));
    }
}
