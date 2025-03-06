package SlidingWindow;

import java.util.ArrayDeque;

public class S2398 {
    /*
    预算内的最多机器人数目
     */

    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int ans = 0, left = 0;
        long sum = 0;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int right = 0; right < chargeTimes.length; right++){
            while (!deque.isEmpty() && chargeTimes[right] >= chargeTimes[deque.peekLast()]){
                deque.pollLast();
            }

            deque.addLast(right);
            sum += runningCosts[right];

            while (!deque.isEmpty() && chargeTimes[deque.peekFirst()] + (right - left + 1) * sum > budget){
                if (deque.peekFirst() == left){
                    deque.pollFirst();
                }
                sum -= runningCosts[left++];
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}
