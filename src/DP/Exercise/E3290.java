package DP.Exercise;

import org.junit.Test;

import java.util.Arrays;

public class E3290 {
    /*
    最高乘法得分
     */

    public long maxScore(int[] a, int[] b) {
        int n = b.length;
        long[][] f = new long[n + 1][5];
        Arrays.fill(f[0], 1, 5, Long.MIN_VALUE / 2);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                f[i + 1][j + 1] = Math.max(f[i][j + 1], f[i][j] + (long) a[j] * b[i]);
            }
        }
        return f[n][4];
    }


    @Test
    public void test(){
        System.out.println(maxScore(new int[]{3,2,5,6}, new int[]{2,-6,4,-5,-3,2,-7}));
    }
}
