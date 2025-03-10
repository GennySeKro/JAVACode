package monotoneStack;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Stack;

public class mS84 {
    /*
    柱状图中最大的矩形
     */

    public int largestRectangleArea(int[] heights) {
        // 在 heights 两端加 0，确保栈中元素都能正确出栈计算面积
        int n = heights.length;
        int[] newHeights = new int[n + 2];
        System.arraycopy(heights, 0, newHeights, 1, n); // 复制原数组到 newHeights[1:n+1]

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i < newHeights.length; i++) {
            while (!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]) {
                int height = newHeights[stack.pop()];
                int width = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }

    @Test
    public void test(){
        System.out.println(largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
}
