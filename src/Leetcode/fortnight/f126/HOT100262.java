package Leetcode.fortnight.f126;

import org.junit.Test;

public class HOT100262 {
    /*
    求出加密整数的和
     */

    public int sumOfEncryptedInt(int[] nums) {
        int sum = 0;
        for (int i = 0;i < nums.length;i++){
            sum = sum + transfer(nums[i]);
        }
        return sum;
    }

    private int transfer(int num) {
        int max = 0;
        int len = 0;
        while (num != 0){
            max = Math.max(max, num % 10);
            len++;
            num = num / 10;
        }
        int res = 0;
        while (len > 0){
            res = res * 10 + max;
            len--;
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(sumOfEncryptedInt(new int[]{10,21,31}));
    }


}
