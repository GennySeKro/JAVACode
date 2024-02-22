public class HOT1049 {
    /*
    最后一块石头的重量Ⅱ
     */

    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int i = 0;i < stones.length;i++){
            sum = sum + stones[i];
        }
        int[] dp = new int[sum / 2 + 1];

        for(int i = 0;i < stones.length;i++){
            for(int j = sum / 2;j >= stones[i];j--){
                dp[j] = Math.max(dp[j],dp[j-stones[i]]+stones[i]);
            }
        }

        return sum - 2 * dp[sum/2];
    }
}
