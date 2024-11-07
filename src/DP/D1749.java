package DP;

import org.junit.Test;

public class D1749 {
    /*
    任意子数组和的绝对值的最大值
     */

    public int maxAbsoluteSum(int[] nums) {
        int s = 0, mx = 0, mn = 0;
        for (int x : nums) {
            s += x;
            // mx = Math.max(mx, s);
            // mn = Math.min(mn, s);
            if (s > mx) mx = s;
            else if (s < mn) mn = s; // 效率更高的写法
        }
        return mx - mn;
    }


    @Test
    public void test(){
        System.out.println(maxAbsoluteSum(new int[]{2,-5,1,-4,3,-2}));
    }

}
