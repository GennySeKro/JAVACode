package LCR;

import java.util.PriorityQueue;

public class LCR059 {
    /*
    数据流中的第K大元素
     */

    class KthLargest {

        PriorityQueue<Integer> queue;
        int k;
        public KthLargest(int k, int[] nums) {
            this.k = k;
            queue = new PriorityQueue<>();
            for (int num : nums){
                queue.add(num);
            }
        }

        public int add(int val) {
            queue.add(val);
            while (queue.size() > k){
                queue.poll();
            }
            return queue.peek();
        }
    }
}
