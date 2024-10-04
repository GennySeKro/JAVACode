package SlidingWindow;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class S1438 {
    /*
    绝对差不超过限制的最长连续子数组
     */

    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxValue = new ArrayDeque<>();
        Deque<Integer> minValue = new ArrayDeque<>();

        int res = 0;
        int left = 0, right = 0;

        while (right < nums.length){
            while (!maxValue.isEmpty() && maxValue.getLast() < nums[right]){
                maxValue.pollLast();
            }
            maxValue.offerLast(nums[right]);
            while (!minValue.isEmpty() && minValue.getLast() > nums[right]){
                minValue.pollLast();
            }
            minValue.offerLast(nums[right]);


            if (Math.abs(maxValue.getFirst() - minValue.getFirst()) <= limit){
                res = Math.max(res, right - left + 1);
            }
            while (Math.abs(maxValue.getFirst() - minValue.getFirst()) > limit) {
                if (maxValue.getFirst() == nums[left]){
                    maxValue.pollFirst();
                }
                if (minValue.getFirst() == nums[left]){
                    minValue.pollFirst();
                }
                left++;
            }
            right++;
        }

        return res;
    }

    @Test
    public void test(){
        System.out.println(longestSubarray(new int[]{8,2,4,7}, 4));
    }
}
