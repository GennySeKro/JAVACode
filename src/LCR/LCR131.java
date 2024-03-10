package LCR;

import org.junit.Test;

public class LCR131 {
    /*
    砍竹子
     */

    public int cuttingBamboo(int bamboo_len) {
        int[] dp = new int[bamboo_len + 1];
        for (int i = 2;i <= bamboo_len;i++){
            int curMax = 0;
            for (int j = 1;j < i;j++){
                curMax = Math.max(curMax, Math.max(j * dp[i - j], j * (i - j)));
            }
            dp[i] = curMax;
        }
        return dp[bamboo_len];
    }

    @Test
    public void test(){
        System.out.println(cuttingBamboo(12));
    }
}
