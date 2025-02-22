package HOT100;

import org.junit.Test;

public class HOT121 {
    /*
    买卖股票的最佳时机
     */

    public int maxProfit(int[] prices) {
        if (prices.length == 1){
            return 0;
        }

        int res = Integer.MIN_VALUE;
        int minIndex = 0;
        for (int i = 1;i < prices.length;i++){
            if (prices[i] < prices[minIndex]){
                minIndex = i;

            }
            res = prices[i] - prices[minIndex] > 0 ? Math.max(res, prices[i] - prices[minIndex]) : res;
        }

        return res == Integer.MIN_VALUE ? 0 : res;
    }

    @Test
    public void test(){
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
