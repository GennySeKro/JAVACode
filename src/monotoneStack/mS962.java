package monotoneStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class mS962 {
    /*
    最大宽度坡
     */

    public int maxWidthRamp(int[] nums) {
        Deque<Integer> stack=new ArrayDeque<>();
        int res=0;
        for(int i=0;i<nums.length;i++){
            if(stack.isEmpty() || nums[stack.peek()]>nums[i]){
                stack.push(i);
            }
        }
        for(int i=nums.length-1;i>=0;i--){
            while(!stack.isEmpty() && nums[stack.peek()]<=nums[i]){
                int cur=stack.pop();
                res=Math.max(res,i-cur);
            }
        }
        return res;
    }
}
