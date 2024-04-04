package Leetcode.week.week392;

import org.junit.Test;

public class HOT100264 {
    /*
    最长的严格递增或递减子数组
     */

    public int longestMonotonicSubarray(int[] nums) {
        int res = 1;
        int addlen = 1;
        for (int i = 1;i < nums.length;i++){
            if (nums[i] > nums[i - 1]){
                addlen++;
            }else {
                res = Math.max(res, addlen);
                addlen = 1;
            }
        }
        res = Math.max(res, addlen);

        int sublen = 1;
        for (int i = 1;i < nums.length;i++){
            if (nums[i] < nums[i - 1]){
                sublen++;
            }else {
                res = Math.max(res, sublen);
                sublen = 1;
            }
        }
        res = Math.max(res, sublen);
        return res;
    }


    @Test
    public void test(){
        System.out.println(longestMonotonicSubarray(new int[]{3,2,1}));
    }
}
