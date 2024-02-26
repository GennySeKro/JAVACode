package HOT;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HOT3 {
    /*
    无重复字符串的最长子串
     */

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i, ans = 0, left = 0;
        for (i = 0;i < s.length();i++){
            if (map.containsKey(s.charAt(i))){
                ans = Math.max(ans, i - left);
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
        }
        return Math.max(ans, i - left);
    }
}
