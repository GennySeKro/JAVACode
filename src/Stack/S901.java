package Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class S901 {
    /*
    股票价格跨度
     */

    class StockSpanner {

        private final Deque<int[]> stack = new ArrayDeque<>();
        private int curDay = -1; // 第一个 next 调用算作第 0 天

        public StockSpanner() {
            stack.push(new int[]{-1, Integer.MAX_VALUE}); // 这样无需判断栈为空的情况
        }

        public int next(int price) {
            while (price >= stack.peek()[1]) {
                stack.pop(); // 栈顶数据后面不会再用到了，因为 price 更大
            }
            int ans = ++curDay - stack.peek()[0];
            stack.push(new int[]{curDay, price});
            return ans;
        }
    }
}
