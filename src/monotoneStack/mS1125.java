package monotoneStack;

import java.util.ArrayDeque;

public class mS1125 {
    /*
    表现良好的最长时间段
     */

    public int longestWPI(int[] hours) {
        int n = hours.length, res = 0;
        int[] preSum = new int[n + 1];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (int i = 1; i <= n; i++){
            preSum[i] = preSum[i - 1] + ((hours[i - 1] > 8) ? 1 : -1);
            if (preSum[i] < preSum[stack.peek()]){
                stack.push(i);
            }
        }

        for (int i = n; i > 0; i--){
            while (!stack.isEmpty() && preSum[i] > preSum[stack.peek()]){
                res = Math.max(res, i - stack.pop());
            }
        }

        return res;
    }
}
