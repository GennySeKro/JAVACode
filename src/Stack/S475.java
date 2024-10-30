package Stack;

import java.util.Stack;

public class S475 {
    /*
    商品折扣后的最终价格
     */

    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[prices.length];

        for (int i = 0;i < prices.length;i++){
            while (!stack.empty() && prices[i] <= prices[stack.peek()]){
                int index = stack.pop();
                res[index] =  prices[index] - prices[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            int index = stack.pop();
            res[index] = prices[index];
        }

        return res;
    }
}
