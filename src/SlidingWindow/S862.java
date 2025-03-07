package SlidingWindow;

import java.util.ArrayDeque;

public class S862 {
    /*
    和至少为K的最短子数组
     */

    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length, ans = n + 1;
        long[] s = new long[n + 1];
        for (int i = 0;i < n; i++){
            s[i + 1] = nums[i] + s[i];
        }

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0;i <= n; i++){
            long curS = s[i];
            while (!deque.isEmpty() && curS - s[deque.peekFirst()] >= k){
                ans = Math.min(ans, i - deque.pollFirst());
            }

            while (!deque.isEmpty() && s[deque.peekLast()] >= curS){
                deque.pollLast();
            }

            deque.addLast(i);
        }

        return ans > n ? -1 : ans;
    }
}
