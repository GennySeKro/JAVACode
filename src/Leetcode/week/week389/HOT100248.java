package Leetcode.week.week389;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class HOT100248 {
    /*
    字符串及其反转中是否存在同一子字符串
     */

    public boolean isSubstringPresent(String s) {
        Set<String> sSet = new HashSet<>();
        String[] reverse = new String[s.length() - 1];
        for (int i = 0;i < s.length() - 1;i++){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(s.charAt(i));
            stringBuilder.append(s.charAt(i + 1));

            sSet.add(stringBuilder.toString());
            reverse[i] = stringBuilder.reverse().toString();
        }
        for (int i = 0;i < sSet.size();i++){
            if (sSet.contains(reverse[i])){
                return true;
            }
        }
        return false;
    }

    @Test
    public void test(){
        System.out.println(isSubstringPresent("abcd"));
    }
}
