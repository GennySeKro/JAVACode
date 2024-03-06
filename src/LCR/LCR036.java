package LCR;

import org.junit.Test;

import java.util.Objects;
import java.util.Stack;

public class LCR036 {
    /*
    逆波兰表达式求值
     */

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0;i < tokens.length;i++){
            if (!Objects.equals(tokens[i], "+") && !Objects.equals(tokens[i], "-") && !Objects.equals(tokens[i], "*") && !Objects.equals(tokens[i], "/")){
                stack.push(Integer.valueOf(tokens[i]));
            }else {
                int first = stack.pop();
                int second = stack.pop();
                switch (tokens[i]){
                    case "+" : stack.push(second + first);break;
                    case "-" : stack.push(second - first);break;
                    case "*" : stack.push(second * first);break;
                    case "/" : stack.push(second / first);break;
                }
            }
        }
        return stack.pop();
    }

    @Test
    public void test(){
        System.out.println(evalRPN(new String[]{"2","1","+","3","*"}));
    }
}
