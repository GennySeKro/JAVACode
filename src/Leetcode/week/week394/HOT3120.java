package Leetcode.week.week394;

public class HOT3120 {
    /*
    统计特殊字母的数量Ⅰ
     */

    public int numberOfSpecialChars(String word) {
        int[] small = new int[26];
        int[] big = new int[26];

        for (int i = 0;i < word.length();i++){
            char temp = word.charAt(i);
            if (temp >= 'a' && temp <= 'z'){
                small[temp - 'a']++;
            } else if (temp >= 'A' && temp <= 'Z') {
                big[temp - 'A']++;
            }
        }

        int res = 0;
        for (int i = 0;i < 26;i++){
            if (small[i] != 0 && big[i] != 0){
                res++;
            }
        }
        return res;
    }
}
