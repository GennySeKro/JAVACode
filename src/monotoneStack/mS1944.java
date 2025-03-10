package monotoneStack;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;

public class mS1944 {
    /*
    队列中可以看到的人数
     */

    public int[] canSeePersonsCount(int[] heights) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int[] res = new int[heights.length];

        for (int i = heights.length - 1; i >= 0; i--){
            while (!deque.isEmpty() && deque.peek() < heights[i]){
                deque.pop();
                res[i]++;
            }

            if (!deque.isEmpty()){
                res[i]++;
            }
            deque.push(heights[i]);
        }

        return res;
    }


    @Test
    public void test(){
        System.out.println(Arrays.toString(canSeePersonsCount(new int[]{10,6,8,5,11,9})));
    }
}
