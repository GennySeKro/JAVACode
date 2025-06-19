package Leetcode.week.week454;

import org.junit.Test;

import java.util.ArrayDeque;

public class Q3 {
    /*
    子序列首尾元素的最大乘积
     */

    public long maximumProduct(int[] nums, int m) {
        ArrayDeque<Integer> maxDeque = new ArrayDeque<>();
        ArrayDeque<Integer> minDeque = new ArrayDeque<>();
        long res = (long) nums[0] * nums[nums.length - 1];
        if (m == 1){
            for (int num : nums){
                res = Math.max(res, (long) num * num);
            }
            return res;
        }

        for (int i = m - 1; i < nums.length; i++){
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] < nums[i]){
                maxDeque.pollLast();
            }
            maxDeque.add(i);

            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] > nums[i]){
                minDeque.pollLast();
            }
            minDeque.add(i);
        }

        for (int i = 0; i <= nums.length - m; i++){
            if (nums[i] >= 0){
                res = Math.max(res, (long) nums[i] * nums[maxDeque.peek()]);
            } else if (nums[i] < 0) {
                res = Math.max(res, (long) nums[i] * nums[minDeque.peek()]);
            }

            if (maxDeque.peek() - i <= m - 1){
                maxDeque.pollFirst();
            }

            if (minDeque.peek() - i <= m - 1){
                minDeque.pollFirst();
            }

        }
        return res;
    }


    @Test
    public void test(){
        System.out.println(maximumProduct(new int[]{-5,0,5,5,10,-2,-4,1,10,3,9,4}, 11));
    }
}
