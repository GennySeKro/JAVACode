package SlidingWindow;

import java.util.ArrayDeque;

public class S1499 {
    /*
    满足不等式的最大值
     */

    public int findMaxValueOfEquation(int[][] points, int k) {
        int ans = Integer.MIN_VALUE;
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        for (int[] point : points){
            int x = point[0], y = point[1];
            while (!deque.isEmpty() && deque.peekFirst()[0] < x - k){
                deque.pollFirst();
            }

            if (!deque.isEmpty()){
                ans = Math.max(ans, x + y + deque.peekFirst()[1]);
            }

            while (!deque.isEmpty() && deque.peekLast()[1] <= y - x){
                deque.pollLast();
            }
            deque.addLast(new int[]{x, y - x});
        }

        return ans;
    }
}
