package HOT100;

import org.junit.Test;

import java.util.ArrayDeque;

public class HOT20 {
    /*
    有效的括号
     */

    public boolean isValid(String s) {
        boolean res = true;
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()){
            if (c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else {
                if (stack.isEmpty()){
                    return false;
                }else {
                    Character tempChar = stack.poll();
                    switch (c){
                        case ')' : res = tempChar == '(';break;
                        case '}' : res = tempChar == '{';break;
                        case ']' : res = tempChar == '[';break;
                    }
                    if (res == false){
                        return false;
                    }
                }
            }
        }

        return stack.isEmpty() ? res : false;
    }

    @Test
    public void test(){
        System.out.println(isValid("({{{{}}}))"));
    }
}
