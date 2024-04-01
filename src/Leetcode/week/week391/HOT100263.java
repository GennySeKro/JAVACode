package Leetcode.week.week391;

import org.junit.Test;

public class HOT100263 {
    /*
    哈沙德数
     */

    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int res = 0, temp = x;
        while (temp != 0){
            res = res + temp % 10;
            temp = temp / 10;
        }
        if (x % res == 0){
            return res;
        }else{
            return -1;
        }
    }

    @Test
    public void test(){
        System.out.println(sumOfTheDigitsOfHarshadNumber(18));
    }
}
