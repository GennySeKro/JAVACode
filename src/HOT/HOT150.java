package HOT;

import org.junit.Test;

import java.util.Stack;

public class HOT150 {
    /*
    逆波兰表达式求值
     */

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i < tokens.length;i++){
            int first, second;
           switch (tokens[i]){
               case "+" :
                   first = stack.pop();
                   second = stack.pop();
                   stack.push(first + second);
                   break;
               case "-" :
                   first = stack.pop();
                   second = stack.pop();
                   stack.push(second - first);
                   break;
               case "*" :
                   first = stack.pop();
                   second = stack.pop();
                   stack.push(second * first);
                   break;
               case "/" :
                   first = stack.pop();
                   second = stack.pop();
                   stack.push(second / first);
                   break;
               default:
                   stack.push(Integer.valueOf(tokens[i]));
                   break;
           }
        }
        return stack.peek();
    }


    @Test
    public void test(){
        System.out.println(evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
}
