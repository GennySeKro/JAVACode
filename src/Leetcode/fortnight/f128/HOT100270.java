package Leetcode.fortnight.f128;

public class HOT100270 {
    /*
    字符串的分数
     */

    public int scoreOfString(String s) {
        int res = 0;
        for (int i = 0;i < s.length() - 1;i++){
            res = res + Math.abs(s.charAt(i) - s.charAt(i + 1));
        }
        return res;
    }
}
