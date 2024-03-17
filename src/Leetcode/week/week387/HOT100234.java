package Leetcode.week.week387;

import org.junit.Test;

public class HOT100234 {
    /*
    在矩阵上写出字母 Y 所需的最少操作次数
     */

    public int minimumOperationsToWriteY(int[][] grid) {
        int[] yc = new int[3], oc = new int[3];
        int n = grid.length;
        int mid = n / 2;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == j && i <= mid) {
                    yc[grid[i][j]] += 1;
                } else if (i + j == n - 1 && i <= mid) {
                    yc[grid[i][j]] += 1;
                } else if (mid == j && i > mid) {
                    yc[grid[i][j]] += 1;
                } else {
                    oc[grid[i][j]] += 1;
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (i != j) {
                    res = Math.min(res, differCount(yc, i) + differCount(oc, j));
                }
            }
        }
        return res;
    }

    private int differCount(int[] arr, int target) {
        int res = 0;
        for (int i = 0; i < arr.length; ++i) {
            if (i != target) res += arr[i];
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(minimumOperationsToWriteY(new int[][]{{0,0,1},{0,0,2},{1,0,2}}));
    }
}
