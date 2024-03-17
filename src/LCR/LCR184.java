package LCR;

import java.util.*;

public class LCR184 {
    /*
    设计自助结算系统
     */

    class Checkout {
        Queue<Integer> q;
        Deque<Integer> d;

        public Checkout() {
            q = new LinkedList<Integer>();
            d = new LinkedList<Integer>();
        }

        public int get_max() {
            if (d.isEmpty()) {
                return -1;
            }
            return d.peekFirst();
        }

        public void add(int value) {
            while (!d.isEmpty() && d.peekLast() < value) {
                d.pollLast();
            }
            d.offerLast(value);
            q.offer(value);
        }

        public int remove() {
            if (q.isEmpty()) {
                return -1;
            }
            int ans = q.poll();
            if (ans == d.peekFirst()) {
                d.pollFirst();
            }
            return ans;
        }
    }
}
