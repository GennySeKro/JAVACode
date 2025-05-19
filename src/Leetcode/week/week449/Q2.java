package Leetcode.week.week449;

import org.junit.Test;

import java.util.Arrays;

public class Q2 {
    /*
    等和矩阵分割Ⅰ
     */

    public boolean canPartitionGrid(int[][] grid) {
        //水平切割
        long[] row = new long[grid.length];
        //垂直切割
        long[] col = new long[grid[0].length];

        long sum = 0L;

        for (int i = 0;i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                row[i] += grid[i][j];
                col[j] += grid[i][j];
                sum += grid[i][j];
            }
        }

        long tempSum = 0L;
        for (long num : row){
            tempSum += num;
            if (tempSum * 2 == sum){
                return true;
            } else if (tempSum * 2 > sum) {
                break;
            }
        }

        tempSum = 0L;
        for (long num : col){
            tempSum += num;
            if (tempSum * 2 == sum){
                return true;
            } else if (tempSum * 2 > sum) {
                break;
            }
        }

        return false;
    }

    @Test
    public void test(){
        System.out.println(canPartitionGrid(new int[][]{{54756,54756}}));
    }
}
