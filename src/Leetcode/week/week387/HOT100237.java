package Leetcode.week.week387;

import org.junit.Test;

public class HOT100237 {
    /*
    元素和小于等于K的子矩阵数目
     */

    public int countSubmatrices(int[][] grid, int k) {
        int res = 0;
        //dp[i][j] == i行j列矩阵的和
        int[][] dp = new int[grid.length][grid[0].length];
        int sum = 0;
        for (int i = 0;i < grid[0].length;i++){
            dp[0][i] = sum + grid[0][i];
            sum = dp[0][i];
        }
        for (int i = 1;i < grid.length;i++){
            sum = 0;
            for (int j = 0;j < grid[0].length;j++){
                sum = sum + grid[i][j];
                dp[i][j] = dp[i - 1][j] + sum;
            }
        }
        for (int i = 0;i < dp.length;i++){
            for (int j = 0;j < dp[0].length;j++){
                if (dp[i][j] <= k){
                    res = res + 1;
                }else {
                    continue;
                }
            }
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(countSubmatrices(new int[][]{{7,2,9},{1,5,0},{2,6,6}}, 20));
    }
}
