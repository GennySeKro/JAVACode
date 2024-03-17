package Leetcode.fortnight.f126;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

public class HOT100209 {
    /*
    执行操作标记数组中的元素
     */

    public long[] unmarkedSumArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;
        long[] answer = new long[m];
        long total = 0;
        boolean[] marked = new boolean[n]; // 用于标记元素是否被处理过
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0]; // 按照元素值排序
            } else {
                return a[1] - b[1]; // 如果值相等，按照下标排序
            }
        });

        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
            total = total + nums[i];
        }

        for (int i = 0; i < m; i++) {
            int index = queries[i][0];
            int k = queries[i][1];
            int sum = 0;

            // 如果 index 对应的元素还没标记，则标记它
            if (!marked[index]) {
                marked[index] = true;
                sum = sum + nums[index];
            }

            // 标记 k 个最小元素

            while (k > 0 && !pq.isEmpty()) {
                int[] curr = pq.poll();
                int value = curr[0];
                int idx = curr[1];
                if (!marked[idx]) {
                    marked[idx] = true;
                    sum += value;
                    k--;
                }
            }
            answer[i] = total - sum;
            total = total - sum;
        }


        return answer;
    }



    @Test
    public void test(){
        System.out.println(Arrays.toString(unmarkedSumArray(new int[]{1, 2, 2, 1, 2, 3, 1}, new int[][]{{1, 2}, {3, 3}, {4, 2}})));
    }
}
