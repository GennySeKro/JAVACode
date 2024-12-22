package HOT100;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class HOT155 {
    /*
    最小栈
     */

    class MinStack {
        // 注意不要使用 Stack 类，因为它继承自 Vector，是同步的，会导致一些性能问题
        private final Deque<int[]> st = new ArrayDeque<>();

        public MinStack() {
            // 添加栈底哨兵 Integer.MAX_VALUE
            // 这里的 0 写成任意数都可以，反正用不到
            st.push(new int[]{0, Integer.MAX_VALUE});
        }

        public void push(int val) {
            st.push(new int[]{val, Math.min(getMin(), val)});
        }

        public void pop() {
            st.pop();
        }

        public int top() {
            return st.peek()[0];
        }

        public int getMin() {
            return st.peek()[1];
        }
    }



    @Test
    public void test(){
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();
        minStack.pop();
        minStack.top();
        minStack.getMin();
    }
}
