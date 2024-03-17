package LCR;

import org.junit.Test;

import java.util.Stack;

public class LCR48 {
    /*
    验证图书取出顺序
     */

    public boolean validateBookSequences(int[] putIn, int[] takeOut) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i = 0;i < putIn.length;i++){
            stack.push(putIn[i]);
            while (!stack.isEmpty() && stack.peek() == takeOut[index]){
                stack.pop();
                index++;
            }
        }
        if (!stack.isEmpty()){
            return false;
        }
        return true;
    }

    @Test
    public void test(){
        System.out.println(validateBookSequences(new int[]{2,1,0}, new int[]{1,2,0}));
    }
}
