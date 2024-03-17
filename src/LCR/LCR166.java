package LCR;

import org.junit.Test;

public class LCR166 {
    /*
    珠宝的最高价值
     */

    public int jewelleryValue(int[][] frame) {
        int[][] dp = new int[frame.length][frame[0].length];
        dp[0][0] = frame[0][0];
        for (int i = 1;i < frame[0].length;i++){
            dp[0][i] = frame[0][i] + dp[0][i - 1];
        }
        for (int i = 1;i < frame.length;i++){
            dp[i][0] = dp[i - 1][0] + frame[i][0];
        }
        for (int i = 1;i < frame[0].length;i++){
            for (int j = 1;j < frame.length;j++){
                dp[j][i] = Math.max(dp[j - 1][i], dp[j][i - 1]) + frame[j][i];
            }
        }
        return dp[frame.length - 1][frame[0].length - 1];
    }


    @Test
    public void test(){
        System.out.println(jewelleryValue(new int[][]{{1,2,5},{3,2,1}}));
    }
}
