package HOT100;

import org.junit.Test;

import java.util.HashMap;

public class HOT3 {
    /*
    无重复字符的最长子串
     */

    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int left = 0, right = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (right < s.length()){
            if (map.containsKey(s.charAt(right))){
                res = Math.max(res, right - left);
                int newLeftIndex = map.get(s.charAt(right));
                while (left <= newLeftIndex){
                    map.remove(s.charAt(left));
                    left++;
                }
            }
            map.put(s.charAt(right), right);
            right++;
        }
        res = Math.max(res, right - left);
        return res;
    }

    @Test
    public void test(){
        System.out.println(lengthOfLongestSubstring(" "));
    }
}
