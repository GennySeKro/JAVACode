package Leetcode.week.week453;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q3 {
    /*
    统计极差最大为K的分割方式数
     */

    private static final int MOD = 1_000_000_007;

    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> minQ = new ArrayDeque<>();
        Deque<Integer> maxQ = new ArrayDeque<>();
        int[] f = new int[n + 1];
        f[0] = 1;

        long sumF = 0L;//窗口中的f[i]之和
        int left = 0;

        for (int i = 0; i < n; i++) {
            sumF += f[i];
            int x = nums[i];

            while (!minQ.isEmpty() && nums[minQ.peekLast()] >= x) {
                minQ.pollLast();
            }
            minQ.addLast(i);

            while (!maxQ.isEmpty() && nums[maxQ.peekLast()] <= x) {
                maxQ.pollLast();
            }
            maxQ.addLast(i);

            while (nums[maxQ.peekFirst()] - nums[minQ.peekFirst()] > k) {
                sumF -= f[left];
                left++;
                if (minQ.peekFirst() < left) {
                    minQ.pollFirst();
                }
                if (maxQ.peekFirst() < left) {
                    maxQ.pollFirst();
                }
            }
            f[i + 1] = (int) (sumF % MOD);
        }

        return f[n];
    }
}
