package LCR;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LCR016 {
    /*
    无重复字符的最长子串
     */

    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()){
            return 0;
        } else if (s.length() == 1) {
            return 1;
        }
        int len = 1;
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        int left = 0, right = 1;
        while (right < s.length()){
            if (!set.contains(s.charAt(right))){
                map.put(s.charAt(right), right);
                set.add(s.charAt(right));
                len = Math.max(len, right - left + 1);
                right++;
            }else {
                while (left < map.get(s.charAt(right)) + 1){
                    set.remove(s.charAt(left));
                    left++;
                }
                len = Math.max(len, right - left + 1);
                map.put(s.charAt(right), right);
                set.add(s.charAt(right));
                right++;
            }
        }
        return len;
    }

    @Test
    public void test(){
        System.out.println(lengthOfLongestSubstring("au"));
    }
}
