package LCR;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LCR042 {
    /*
    最近的请求次数
     */

    class RecentCounter {

        int count;
        int request;
        Queue<Integer> queue;

        public RecentCounter() {
            count = 0;
            request = 0;
            queue = new ArrayDeque<>();
        }

        public int ping(int t) {
            queue.offer(t);
            int res = 0;
            while (queue.peek() < t - 3000){
                queue.poll();
            }
            return queue.size();
        }
    }
}
