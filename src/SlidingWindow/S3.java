package SlidingWindow;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class S3 {
    /*
    无重复字符的最长子串
     */

    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()){
            return 0;
        }
        int res = 1;
        int left = 0, right = 1;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);
        while (right < s.length()){
            if (!map.containsKey(s.charAt(right))){
                map.put(s.charAt(right), right);
            }else {
                left = Math.max(left, map.get(s.charAt(right)) + 1);
                map.put(s.charAt(right), right);
            }
            res = Math.max(res, right - left + 1);
            right++;
        }

        return res;
    }

    @Test
    public void test(){
        System.out.println(lengthOfLongestSubstring("abba"));
    }
}
