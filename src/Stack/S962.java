package Stack;

import java.util.Stack;

public class S962 {
    /*
    最大宽度坡
     */

    public int maxWidthRamp(int[] A) {

        int n = A.length;
        int maxWidth = 0;

        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<n;i++) {

            if (stack.isEmpty() || A[stack.peek()] > A[i]) {

                stack.push(i);
            }
        }

        for (int i=n-1;i>=0;i--) {

            while (!stack.isEmpty() && A[stack.peek()] <= A[i]) {

                int pos = stack.pop();
                maxWidth = Math.max(maxWidth, i - pos);
            }
        }
        return maxWidth;
    }
}
