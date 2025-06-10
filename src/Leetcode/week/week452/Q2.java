package Leetcode.week.week452;

import java.util.Arrays;

public class Q2 {
    /*
    子矩阵的最小绝对差
     */

    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m - k + 1][n - k + 1];
        int[] gridK = new int[k * k];
        for (int i = 0; i <= m - k; i++){
            for (int j = 0; j <= n - k; j++){
                int index = 0;
                for (int x = 0; x < k; x++){
                    for (int y = 0; y < k; y++){
                        gridK[index++] = grid[i + x][j + y];
                    }
                }

                Arrays.sort(gridK);

                int tempMin = Integer.MAX_VALUE;
                for (int p = 1; p < gridK.length; p++){
                    if (gridK[p] > gridK[p - 1]){
                        tempMin = Math.min(tempMin, gridK[p] - gridK[p - 1]);
                    }
                }

                if (tempMin < Integer.MAX_VALUE){
                    res[i][j] = tempMin;
                }
            }
        }

        return res;
    }
}
