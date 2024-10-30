package Stack;

import java.util.ArrayDeque;

public class S1123 {
    /*
    表现良好的最长时间段
     */

    public int longestWPI(int[] hours) {
        int[] preSum = new int[hours.length + 1];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.push(0);
        for (int i = 1; i <= hours.length;i++){
            preSum[i] = preSum[i - 1] + (hours[i - 1] > 8 ? 1 : -1);
            if (preSum[i] < preSum[queue.peek()]){
                queue.push(i);
            }
        }

        int res = 0;
        for (int i = hours.length;i > 0;i--){
            while (!queue.isEmpty() && preSum[queue.peek()] < preSum[i]){
                res = Math.max(res, i - queue.poll());
            }
        }

        return res;
    }
}
