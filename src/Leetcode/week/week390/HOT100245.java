package Leetcode.week.week390;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class HOT100245 {
    /*
    每个字符最多出现两次的最长子字符串
     */

    public int maximumLengthSubstring(String s) {
        int res = Integer.MIN_VALUE;
        for (int i = 0;i < s.length();i++){
            Map<Character, Integer> map = new HashMap<>();
            map.put(s.charAt(i), 1);
            boolean flag = false;
            for (int j = i + 1;j < s.length();j++){
                if (map.containsKey(s.charAt(j))){
                    if (map.get(s.charAt(j)) == 2){
                        res = Math.max(res, j - i);
                        flag = true;
                        break;
                    }else {
                        map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                    }
                }else {
                    map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                }
            }
            if (!flag){
                res = Math.max(res, s.length() - i);
            }
        }

        return res;
    }

    @Test
    public void test(){
        System.out.println(maximumLengthSubstring("bcbbbcba"));
    }
}
