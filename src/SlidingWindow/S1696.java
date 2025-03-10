package SlidingWindow;

import java.util.ArrayDeque;

public class S1696 {
    /*
    跳跃游戏Ⅵ
     */

    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] f = new int[n];
        f[0] = nums[0];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addLast(0);
        for (int i = 1; i < n; i++){
            if (deque.peekFirst() < i - k){
                deque.pollFirst();
            }

            f[i] = f[deque.peekFirst()] + nums[i];

            while (!deque.isEmpty() && f[deque.peekLast()] <= f[i]){
                deque.pollLast();
            }
            deque.addLast(i);
        }

        return f[n - 1];
    }
}
