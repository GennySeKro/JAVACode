package LCR;

import org.junit.Test;

public class LCR127 {
    /*
    跳跃训练
     */

    public int trainWays(int num) {
        if (num == 0){
            return 1;
        } else if (num == 1) {
            return 1;
        }
        int[] dp = new int[num];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2;i < num;i++){
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[num - 1];
    }

    @Test
    public void test(){
        System.out.println(trainWays(5));
    }
}
