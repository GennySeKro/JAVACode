package HOT100;

import org.junit.Test;

import java.util.Stack;

public class HOT32 {
    /*
    最长有效括号
     */

    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();

        int res = 0, start = 0;
        for (int i = 0;i < s.length();i++){
            if (s.charAt(i) == '('){
                stack.push(i);
            }else {
                if (!stack.isEmpty()){
                    stack.pop();
                    if (stack.isEmpty()){
                        res = Math.max(res, i - start + 1);
                    }else {
                        res = Math.max(res, i - stack.peek());
                    }
                }else {
                    start = i + 1;
                }
            }
        }

        return res;
    }

    @Test
    public void test(){
        System.out.println(longestValidParentheses("(()"));
    }
}
