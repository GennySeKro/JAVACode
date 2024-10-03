package SlidingWindow;

import java.util.Deque;
import java.util.LinkedList;

public class S2762 {
    /*
    不间断子数组
     */

    public long continuousSubarrays(int[] nums) {
        Deque<Integer> maxQueue = new LinkedList<>();
        Deque<Integer> minQueue = new LinkedList<>();

        int right = 0, left = 0;
        long res = 0L;

        while (right < nums.length){
            while (!maxQueue.isEmpty() && maxQueue.getLast() < nums[right]){
                maxQueue.pollLast();
            }
            while (!minQueue.isEmpty() && minQueue.getLast() > nums[right]){
                minQueue.pollLast();
            }
            maxQueue.offerLast(nums[right]);
            minQueue.offerLast(nums[right]);

            while (!maxQueue.isEmpty() && !minQueue.isEmpty() &&
            Math.abs(maxQueue.getFirst() - minQueue.getFirst()) > 2){
                if (nums[left] == maxQueue.getFirst()){
                    maxQueue.pollFirst();
                }
                if (nums[left] == minQueue.getFirst()){
                    maxQueue.pollFirst();
                }
                left++;
            }
            res += right - left + 1;
            right++;
        }
        return res;
    }
}
