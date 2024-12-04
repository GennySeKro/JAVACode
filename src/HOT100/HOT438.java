package HOT100;

import java.util.ArrayList;
import java.util.List;

public class HOT438 {
    /*
    找到字符串中所有字母异位词
     */

    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int[] charArray = new int[26];
        for (char c : p.toCharArray()){
            charArray[c - 'a']++;
        }

        int left = 0;
        for (int right = 0;right < s.length();right++){
            int c = s.charAt(right) - 'a';
            charArray[c]--;
            while (charArray[c] < 0){
                charArray[s.charAt(left) - 'a']++;
                left++;
            }
            if (right - left + 1 == p.length()){
                res.add(left);
            }
        }
        return res;

    }
}
