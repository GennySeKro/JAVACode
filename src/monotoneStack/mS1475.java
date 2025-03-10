package monotoneStack;

import java.util.ArrayDeque;

public class mS1475 {
    /*
    商品折扣后的最终价格
     */

    public int[] finalPrices(int[] prices) {
        int[] res = new int[prices.length];
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < prices.length; i++){
            if (deque.isEmpty() || prices[i] > prices[deque.peekLast()]){
                deque.addLast(i);
                continue;
            }

            while (!deque.isEmpty() && prices[i] <= prices[deque.peekLast()]){
                int index = deque.pollLast();
                res[index] = prices[index] - prices[i];
            }

            deque.addLast(i);
        }
        while (!deque.isEmpty()){
            res[deque.peekLast()] = prices[deque.pollLast()];
        }

        return res;
    }
}
