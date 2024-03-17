package Leetcode.week.week389;

import org.junit.Test;

public class HOT100236 {
    /*
    统计以给定字符开头和结尾的子字符串总数
     */

    public long countSubstrings(String s, char c) {
        int num = 0;
        for (int i = 0;i < s.length();i++){
            if (s.charAt(i) == c){
                num++;
            }
        }
        long sum = 0;
        for (int i = 0;i < num;i++){
            sum = sum + (i + 1);
        }
        return sum;
    }

    @Test
    public void test(){
        System.out.println(countSubstrings("avvbcbvc", 'a'));
    }
}
