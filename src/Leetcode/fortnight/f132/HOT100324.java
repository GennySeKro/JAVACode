package Leetcode.fortnight.f132;

import java.util.*;

public class HOT100324 {
    /*
    清除数字
     */

    public String clearDigits(String s) {
        Set<Integer> delIndex = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0;i < s.length();i++){
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                delIndex.add(stack.pop());
                delIndex.add(i);
            }else {
                stack.push(i);
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0;i < s.length();i++){
            if (!delIndex.contains(i)){
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}
