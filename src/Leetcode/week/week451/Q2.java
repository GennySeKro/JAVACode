package Leetcode.week.week451;

import org.junit.Test;

public class Q2 {
    /*
    移除相邻字符
     */

    public String resultingString(String s) {
        StringBuilder res = new StringBuilder();
        res.append(s.charAt(0));
        for (int i = 1; i < s.length(); i++){
            if (res.length() == 0){
                res.append(s.charAt(i));
            }else {
                if (need2Delete(res, s.charAt(i))){
                    res.deleteCharAt(res.length() - 1);
                }else {
                    res.append(s.charAt(i));
                }
            }
        }

        return res.toString();
    }

    private boolean need2Delete(StringBuilder res, char x) {
        if (Math.abs(res.charAt(res.length() - 1) - x) == 1 || Math.abs(res.charAt(res.length() - 1) - x) == 25){
            return true;
        }

        return false;
    }


    @Test
    public void test(){
        System.out.println(resultingString("zadb"));
    }
}
