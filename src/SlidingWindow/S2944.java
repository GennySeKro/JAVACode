package SlidingWindow;

import java.util.ArrayDeque;

public class S2944 {
    /*
    购买水果需要的最少金币数
     */

    public int minimumCoinsRecursion(int[] prices) {
        int n = prices.length;
        int[] memo = new int[(n + 1) / 2];
        return dfs(1, prices, memo);
    }

    private int dfs(int i, int[] prices, int[] memo) {
        if (i * 2 >= prices.length){
            return prices[i - 1];
        }

        if (memo[i] != 0){
            return memo[i];
        }

        int res = Integer.MAX_VALUE;
        for (int j = i + 1; j <= 2 * i + 1; j++){
            res = Math.min(res, dfs(j, prices, memo));
        }

        memo[i] = res + prices[i - 1];
        return res;
    }


    public int minimumCoinsDP(int[] prices) {
        int n = prices.length;
        for (int i = (n + 1) / 2 - 1; i > 0; i--){
            int mn = Integer.MAX_VALUE;
            for (int j = i; j <= 2 * i; j++){
                mn = Math.min(mn, prices[j]);
            }

            prices[i - 1] += mn;
        }

        return prices[0];
    }

    public int minimumCoinsQueue(int[] prices) {
        int n = prices.length;
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.addLast(new int[]{n + 1, 0});
        for (int i = n; i > 0; i--){
            while (deque.peekLast()[0] > i * 2 + 1){
                deque.pollLast();
            }
            int f = prices[i - 1] + deque.peekLast()[1];
            while (f <= deque.peekFirst()[1]){
                deque.pollFirst();
            }
            deque.addFirst(new int[]{i, f});
        }

        return deque.peekFirst()[1];
    }
}
