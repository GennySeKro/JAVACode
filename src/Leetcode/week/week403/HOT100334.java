package Leetcode.week.week403;

import org.junit.Test;

public class HOT100334 {
    /*
    包含所有1的最小矩形面积
     */

    public int minimumArea(int[][] grid) {
        int top = Integer.MAX_VALUE, left = Integer.MAX_VALUE, right = 0, under = 0;
        for (int i = 0;i < grid.length;i++){
            for (int j = 0;j < grid[0].length;j++){
                if (grid[i][j] == 1){
                    top = Math.min(top, i);
                    left = Math.min(left, j);
                    right = Math.max(right, j);
                    under = Math.max(under, i);
                }
            }
        }
        int res = (under - top + 1) * (right - left + 1);
        return res;
    }

    @Test
    public void test(){
        System.out.println(minimumArea(new int[][]{{0,0},{1,0}}));
    }
}
