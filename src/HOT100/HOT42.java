package HOT100;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class HOT42 {
    /*
    接雨水
     */

    public int trap(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        for (int i = 0;i < height.length;i++){
            if (stack.isEmpty() || height[stack.peek()] > height[i]){
                stack.push(i);
            }else {
                int right = height[i];
                while (!stack.isEmpty() && height[stack.peek()] < right){
                    int bottom = stack.poll();
                    if (!stack.isEmpty()){
                        res += (Math.min(height[stack.peek()], right) - height[bottom]) * (i - stack.peek() - 1);
                    }
                }
                stack.push(i);
            }
        }

        return res;
    }

    @Test
    public void test(){
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
