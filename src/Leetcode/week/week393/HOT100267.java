package Leetcode.week.week393;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class HOT100267 {
    /*
    单面值组合的第 K 小金额
     */

    public long findKthSmallest(int[] nums) {
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        while (i < nums.length){
            //栈为空，直接入栈
            if (stack.isEmpty() ){
                stack.push(nums[i]);
                i++;
                continue;
            }
            //当前非素数，入栈
            if (!isNum(nums[i])){
                stack.push(nums[i]);
                i++;
                continue;
            }
            //栈不空且当前数是素数
            if (isNum(stack.peek()) == true){
                int temp = nums[i] + stack.pop();
                if (isNum(temp)){
                    nums[i] = temp;
                }else {
                    stack.push(temp);
                    i++;
                }
            }else {
                stack.push(nums[i]);
                i++;
                continue;
            }
        }
        return stack.size();
    }

    private static boolean isNum(int num) {
        if (num == 1){
            return false;
        }else if (num == 2){
            return true;
        }
        for (int i = 2;i * i <= num;i++){
            if (num % i == 0){
                return false;
            }
        }
        return true;
        // TODO
    }

    @Test
    public void test(){
        System.out.println(findKthSmallest(new int[]{1,3,2,5,4}));

    }
}
