package LCR;
import org.junit.Test;

import java.util.*;

public class LCR015 {
    /*
    找到字符串中所有字母异位词
     */

    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()){
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        int[] pStr = new int[26];
        int[] tempStr = new int[26];
        for (int i = 0;i < p.length();i++){
            pStr[p.charAt(i) - 'a']++;
            tempStr[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(pStr, tempStr)){
            res.add(0);
        }
        for (int i = p.length();i < s.length();i++){
            tempStr[s.charAt(i) - 'a']++;
            tempStr[s.charAt(i - p.length()) - 'a']--;
            if (Arrays.equals(pStr, tempStr)){
                res.add(i - p.length() + 1);
            }
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }
}
