package monotoneStack;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayDeque;

public class mS456 {
    /*
    132模式
     */

    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        ArrayDeque<Integer> d = new ArrayDeque<>();
        int k = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < k) return true;
            while (!d.isEmpty() && d.peekLast() < nums[i]) {
                // 事实上，k 的变化也具有单调性，直接使用 k = pollLast() 也是可以的
                k = Math.max(k, d.pollLast());
            }
            d.addLast(nums[i]);
        }
        return false;
    }

    @Test
    public void test(){
        System.out.println(find132pattern(new int[]{3,1,4,2}));
    }
}
