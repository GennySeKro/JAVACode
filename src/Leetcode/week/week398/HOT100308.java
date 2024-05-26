package Leetcode.week.week398;

import org.junit.Test;

import java.util.*;

public class HOT100308 {
    /*
    特殊数组Ⅱ
     */


    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        boolean[] res = new boolean[queries.length];
        for (int i = 0;i < queries.length;i++){
            if (isTrue(nums, queries[i][0], queries[i][1])){
                res[i] = true;
            }else {
                res[i] = false;
            }
        }
        return res;
    }

    public boolean isTrue(int[] nums, int left, int right){
        if (left == right){
            return true;
        }
        for (int i = left;i < right;i++){
            if (!(nums[i] % 2 == 0 && nums[i + 1] % 2 != 0 || nums[i] % 2 != 0 && nums[i + 1] % 2 == 0)){
                return false;
            }
        }
        return true;
    }

    @Test
    public void test(){
        System.out.println(Arrays.toString(isArraySpecial(new int[]{3, 4, 1, 2, 6}, new int[][]{{0, 4}})));
    }
}
