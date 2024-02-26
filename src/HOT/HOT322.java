package HOT;

import org.junit.Test;

import java.util.Arrays;

public class HOT322 {
    /*
    零钱兑换
     */

    /*
    直接递归计算
     */
    class one{
        int res = Integer.MAX_VALUE;
        public int coinChange(int[] coins, int amount){
            if(coins.length == 0){
                return 0;
            }

            findWay(coins,amount,0);
            if(res == Integer.MAX_VALUE){
                return -1;
            }
            return res;
        }

        private void findWay(int[] coins, int amount, int count) {
            if(amount < 0){
                return;
            }
            if(amount == 0){
                res = Math.min(res,count);
            }

            for (int coin : coins) {
                findWay(coins, amount - coin, count++);
            }
        }
    }

    /*
    第一种直接递归存在多次重复计算的情况，且容易导致超时
    所以用一个数组来记录计算结果
    时间复杂度O()、空间复杂度O()
     */
    class two{
        int[] memo;
        public int coinChange(int[] coins, int amount) {
            if(coins.length == 0){
                return -1;
            }
            memo = new int[amount];
            return findWay(coins,amount);
        }

        private int findWay(int[] coins, int amount) {
            if(amount < 0){
                return -1;
            }
            if(amount == 0){
                return 0;
            }

            if(memo[amount-1] != 0){
                return memo[amount - 1];
            }
            int min = Integer.MAX_VALUE;
            for(int i = 0;i < coins.length;i++){
                int res = findWay(coins,amount - coins[i]);
                if(res >= 0 && res < min){
                    min = res + 1;
                }
            }

            memo[amount - 1] = (min == Integer.MAX_VALUE ? -1 : min);
            return memo[amount - 1];
        }
    }

    /*
    动态规划
     */
    class three{
        public int coinChange(int[] coins, int amount) {
            int max = Integer.MAX_VALUE;
            int[] dp = new int[amount+1];
            Arrays.fill(dp, max);
            dp[0] = 0;
            for(int i = 0;i < coins.length;i++){
                for(int j = coins[i];j <= amount;j++){
                    if (dp[j - coins[i]] != max) {
                        //选择硬币数目最小的情况
                        dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                    }
                }
            }

            return dp[amount] == max ? -1 : dp[amount];
        }
    }

    @Test
    public void test(){
        System.out.println(new three().coinChange(new int[]{1,2,5},11));
    }
}
