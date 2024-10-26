package HOT;

import java.util.Deque;
import java.util.LinkedList;

public class HOT42 {
    /*
    接雨水
     */

    /*
    动态规划
     */
    class one{
        public int trap(int[] height) {
            if (height.length == 0){
                return 0;
            }

            int[] leftMax = new int[height.length];
            int[] rightMax = new int[height.length];

            leftMax[0] = height[0];
            rightMax[height.length - 1] = height[height.length - 1];

            for (int i = 1;i < height.length;i++){
                leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            }

            for (int i = height.length - 2;i >= 0;i--){
                rightMax[i] = Math.max(rightMax[i + 1], height[i]);
            }

            int res = 0;
            for (int i = 0;i < height.length;i++){
                res = res + Math.min(leftMax[i], rightMax[i]) - height[i];
            }

            return res;
        }
    }

    /*
    单调栈
     */
    class two{
        public int trap(int[] height) {
            int ans = 0;
            Deque<Integer> stack = new LinkedList<Integer>();
            int n = height.length;
            for (int i = 0; i < n; ++i) {
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    int top = stack.pop();
                    if (stack.isEmpty()) {
                        break;
                    }
                    int left = stack.peek();
                    int currWidth = i - left - 1;
                    int currHeight = Math.min(height[left], height[i]) - height[top];
                    ans += currWidth * currHeight;
                }
                stack.push(i);
            }
            return ans;
        }
    }

}
