package Leetcode.week.week394;

import org.junit.Test;

import java.util.Arrays;

public class HOT3121 {
    /*
    统计特殊字母的数量Ⅱ
     */

    public int numberOfSpecialChars(String word) {
        int[] bigIndex = new int[26];
        int[] small = new int[26];
        Arrays.fill(bigIndex, -1);
        Arrays.fill(small, -1);
        for (int i = 0;i < word.length();i++){
            char temp = word.charAt(i);
            if (temp >= 'A' && temp <= 'Z' && bigIndex[temp - 'A'] == -1){
                bigIndex[temp - 'A'] = i;
            }else if (temp >= 'a' && temp <= 'z'){
                small[temp - 'a'] = i;
            }
        }

        int res = 0;
        for (int i = 0;i < 26;i++){
            if (small[i] != -1 && bigIndex[i] != -1){
                if (small[i] < bigIndex[i]){
                    res++;
                }
            }
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(numberOfSpecialChars("EE"));
    }
}
