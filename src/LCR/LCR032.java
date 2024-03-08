package LCR;

import org.junit.Test;

public class LCR032 {
    /*
    有效的字母异位词
     */

    public boolean isAnagram(String s, String t) {
        if (s.equals(t)){
            return false;
        }
        int[] sNum = new int[26];
        int[] tNum = new int[26];
        for (int i = 0;i < s.length();i++){
            sNum[s.charAt(i) - 'a']++;
        }
        for (int i = 0;i < t.length();i++){
            tNum[t.charAt(i) - 'a']++;
        }
        for (int i = 0;i < 26;i++){
            if (sNum[i] != tNum[i]){
                return false;
            }
        }
        return true;
    }

    @Test
    public void test(){
        System.out.println(isAnagram("a", "a"));
    }
}
