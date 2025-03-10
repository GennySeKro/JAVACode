package Leetcode.week.week440;

import org.junit.Test;

import java.util.*;

public class Q2 {
    /*
    选出和最大的K个元素
     */

    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] a = new int[n][3];
        for (int i = 0; i < n; i++) {
            a[i] = new int[]{nums1[i], nums2[i], i};
        }
        Arrays.sort(a, (p, q) -> p[0] - q[0]);

        long[] ans = new long[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long s = 0;
        // 分组循环模板
        for (int i = 0; i < n; ) {
            int start = i;
            int x = a[start][0];
            // 找到所有相同的 nums1[i]，这些数的答案都是一样的
            while (i < n && a[i][0] == x) {
                ans[a[i][2]] = s;
                i++;
            }
            // 把这些相同的 nums1[i] 对应的 nums2[i] 入堆
            for (int j = start; j < i; j++) {
                int y = a[j][1];
                s += y;
                pq.offer(y);
                if (pq.size() > k) {
                    s -= pq.poll();
                }
            }
        }
        return ans;
    }

    @Test
    public void test(){
        System.out.println(Arrays.toString(findMaxSum(new int[]{4, 2, 1, 5, 3}, new int[]{10, 20, 30, 40, 50}, 2)));
    }
}
