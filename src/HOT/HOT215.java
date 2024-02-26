package HOT;

import java.util.PriorityQueue;

public class HOT215 {
    /*
    数组中的第K个元素
    系统API
     */

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        int i = 0;
        for(;i < k;i++){
            queue.add(nums[i]);
        }
        for(;i < nums.length;i++){
            if(queue.peek() < nums[i]){
                queue.poll();
                queue.add(nums[i]);
            }
        }
        return queue.peek();
    }



}
