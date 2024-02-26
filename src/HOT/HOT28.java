package HOT;

import org.junit.Test;

public class HOT28 {
    /*
    找出字符串中第一个匹配项的下标
     */

    public int strStr(String haystack, String needle) {
        int[] next = new int[needle.length()];
        next[0] = 0;
        for (int j = 0, i = 1; i < next.length;){
            if (needle.charAt(i) == needle.charAt(j)){
                next[i] = j + 1;
                j++;
                i++;
            }else {
                if (j == 0){
                    next[i] = 0;
                    i++;
                }else {
                    j = next[j - 1];
                }
            }
        }

        int sum = 0;
        for (int i = 0, j = 0;i < haystack.length();){
            if (haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }else {
                if (j > 0){
                    j = next[j - 1];
                }else {
                    i++;
                }
            }
            if (j == needle.length()){
                return i - j;
            }
        }
        return -1;
    }

    @Test
    public void test(){
        System.out.println(strStr("01001010010100", "01001"));
    }
}
