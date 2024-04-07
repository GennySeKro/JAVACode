package Leetcode.fortnight.f128;

import org.junit.Test;

import java.util.Arrays;

public class HOT100273 {
    /*
    边界元素是最大值的子数组数目
     */

    public long numberOfSubarrays(int[] nums) {
        long res = 0L;
        int temp = nums[0], len = 1;
        for (int i = 1;i < nums.length;i++){
            if (nums[i] == temp){
                len++;
            }else {
                res = res + sum(len);
                temp = nums[i];
                len = 1;
            }
        }
        return res + sum(len);
    }

    private long sum(int len) {
        long res = 0L;
        for (int i = 1;i <= len;i++){
            res = res + i;
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(numberOfSubarrays(new int[]{1,4,3,3,2}));
    }
}
