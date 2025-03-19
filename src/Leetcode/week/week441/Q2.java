package Leetcode.week.week441;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q2 {
    /*
    距离最小相等元素查询
     */

    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        HashMap<Integer, Integer> first = new HashMap<>(); // 记录首次出现的位置
        HashMap<Integer, Integer> last = new HashMap<>(); // 记录最后一次出现的位置
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            left[i] = last.getOrDefault(x, -1);
            if (left[i] >= 0) {
                right[left[i]] = i;
            }
            first.putIfAbsent(x, i);
            last.put(x, i);
        }

        List<Integer> ans = new ArrayList<>(queries.length);
        for (int i : queries) {
            int l = left[i] >= 0 ? left[i] : last.get(nums[i]) - n;
            if (i - l == n) {
                ans.add(-1);
            } else {
                int r = right[i] > 0 ? right[i] : first.get(nums[i]) + n;
                ans.add(Math.min(i - l, r - i));
            }
        }
        return ans;
    }

    @Test
    public void test(){
        System.out.println(solveQueries(new int[]{14,14,4,2,19,19,14,19,14}, new int[]{2,4,8,6,3}));
    }
}
