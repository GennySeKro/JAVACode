package HOT;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

public class HOT20 {
    /*
    有效的括号
     */

    public boolean isValid(String s) {
        char[] res = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i < res.length;i++){
            switch (res[i]){
                case '(': stack.push(res[i]);break;
                case '[': stack.push(res[i]);break;
                case '{': stack.push(res[i]);break;
                case ')':
                    if(stack.empty()){
                        return false;
                    } else if (stack.pop() != '(') {
                        return false;
                    }else {
                        break;
                    }

                case ']':
                    if(stack.empty()){
                        return false;
                    } else if (stack.pop() != '[') {
                        return false;
                    }else {
                        break;
                    }
                case '}':
                    if(stack.empty()){
                        return false;
                    } else if (stack.pop() != '{') {
                        return false;
                    }else {
                        break;
                    }
            }
        }
        if(stack.empty()){
            return true;
        }else return false;

    }

    @Test
    public void test(){
        isValid("(");
    }
}
