package Leetcode.week.week390;

import org.junit.Test;

public class HOT100228 {
    /*
    执行操作使数据元素之和大于等于 K
     */

    public int minOperations(int k) {
        int min = k - 1;
        for (int i = 1; i < k; ++i) {
            int num = i + 1;
            int time = k / num + (k % num == 0 ? 0 : 1) - 1;
            min = Math.min(i + time, min);
        }
        return min;
    }

    @Test
    public void test(){
        System.out.println(minOperations(11));
    }
}
