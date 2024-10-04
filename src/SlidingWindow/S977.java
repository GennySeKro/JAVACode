package SlidingWindow;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class S977 {
    /*
    有序数组的平方
     */

    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int i = 0;
        int j = n - 1;
        for (int p = n - 1; p >= 0; p--) {
            int x = nums[i] * nums[i];
            int y = nums[j] * nums[j];
            if (x > y) {
                ans[p] = x;
                i++;
            } else {
                ans[p] = y;
                j--;
            }
        }
        return ans;
    }

    @Test
    public void test(){
        System.out.println(sortedSquares(new int[]{-4,-1,0,3,10}));
    }
}
