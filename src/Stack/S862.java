package Stack;

import java.util.ArrayDeque;

public class S862 {
    /*
    和至少为K的最短子数组
     */

    public int shortestSubarray(int[] nums, int k) {
        int res = Integer.MAX_VALUE;
        long[] preSum = new long[nums.length + 1];
        for (int i = 0;i < nums.length;i++){
            preSum[i + 1] = preSum[i] + nums[i];
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0;i <= nums.length;i++){
            long tempPreSum = preSum[i];
            while (!queue.isEmpty() && tempPreSum - preSum[queue.peekFirst()] >= k){
                res = Math.min(res, i - queue.pollFirst());
            }

            while (!queue.isEmpty() && tempPreSum <= preSum[queue.peekLast()]){
                queue.pollLast();
            }

            queue.offerLast(i);
        }

        return res == Integer.MAX_VALUE ? -1 : res;

    }
}
