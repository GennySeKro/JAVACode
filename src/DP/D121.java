package DP;

public class D121 {
    /*
    买卖股票的最佳时机
     */

    public int maxProfit(int[] prices) {
        int res = 0;
        int min = Integer.MAX_VALUE;
        for (int price : prices){
            min = Math.min(price, min);
            res = Math.max(price - min, res);
        }

        return res;
    }
}
