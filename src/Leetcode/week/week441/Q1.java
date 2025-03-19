package Leetcode.week.week441;

import org.junit.Test;

import java.util.HashSet;

public class Q1 {
    /*
    删除后的最大数组元素和
     */

    public int maxSum(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        int max = Integer.MIN_VALUE;
        HashSet<Integer> set = new HashSet<>();
        int res = 0;
        for (int num : nums){
            max = Math.max(max, num);
            if (!set.contains(num) && num > 0){
                res += num;
                set.add(num);
            }
        }

        return res == 0 ? max : res;
    }

    @Test
    public void test(){
        System.out.println(maxSum(new int[]{1,2,-1,-2,1,0,-1}));
    }
}
