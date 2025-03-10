package monotoneStack;

import org.junit.Test;

import java.util.ArrayDeque;

public class mS42 {
    /*
    接雨水
     */

    public int trap(int[] height) {
        int res = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < height.length; i++){
            while (!stack.isEmpty() && height[stack.peek()] <= height[i]){
                int bottom = height[stack.pop()];
                if (stack.isEmpty()){
                    break;
                }
                int left = stack.peek();
                int high = Math.min(height[left], height[i]) - bottom;
                res += high * (i - left - 1);
            }

            stack.push(i);

        }

        return res;
    }

    @Test
    public void test(){
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
