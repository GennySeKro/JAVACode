package DP;

import org.junit.Test;

public class D2466 {
    /*
    统计构造好字符串的方案数
     */

    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high + 1];
        dp[zero]++;
        dp[one]++;
        for (int i = 1;i <= high;i++){
            if (i - one >= 0){
                dp[i] += dp[i - one];
            }
            if (i - zero >= 0) {
                dp[i] += dp[i - zero];
            }
            dp[i] %= 1000000007;
        }

        long res = 0L;
        for (int i = low;i <= high;i++){
            res += dp[i];
        }

        return (int) (res % 1000000007);
    }

    @Test
    public void test(){
        System.out.println(countGoodStrings(3,3,1,1));
    }
}
