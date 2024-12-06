package HOT100;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;

public class HOT239 {
    /*
    滑动窗口最大值
     */

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1){
            return nums;
        }

        int[] res = new int[nums.length - k + 1];
        ArrayDeque<Integer> dequeue = new ArrayDeque<>();

        for (int i = 0;i < k;i++){
            while (!dequeue.isEmpty() && nums[dequeue.getLast()] < nums[i]){
                dequeue.pollLast();
            }
            dequeue.addLast(i);
        }
        res[0] = nums[dequeue.getFirst()];

        for (int i = k; i < nums.length; i++){
            if (i - k == dequeue.getFirst()){
                dequeue.pollFirst();
            }

            while (!dequeue.isEmpty() && nums[dequeue.getLast()] < nums[i]){
                dequeue.pollLast();
            }

            dequeue.addLast(i);
            res[i - k + 1] = nums[dequeue.getFirst()];
        }

        return res;
    }

    @Test
    public void test(){
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}
