package monotoneStack;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;

public class mS739 {
    /*
    每日温度
     */

    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < temperatures.length; i++){
            if (stack.isEmpty() || temperatures[stack.peekLast()] >= temperatures[i]){
                stack.addLast(i);
            }

            while (!stack.isEmpty() && temperatures[stack.peekLast()] < temperatures[i]){
                Integer index = stack.pollLast();
                res[index] = i - index;
            }

            stack.addLast(i);

        }

        return res;
    }


    @Test
    public void test(){
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
}
