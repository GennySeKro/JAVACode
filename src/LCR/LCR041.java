package LCR;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

public class LCR041 {
    /*
    数据流中的移动平均值
     */

    class MovingAverage {

        Queue<Integer> queue;
        int len;
        long sum;

        /** Initialize your data structure here. */
        public MovingAverage(int size) {
            this.queue = new ArrayDeque<>();
            this.len = size;
            this.sum = 0;
        }

        public double next(int val) {
            queue.offer(val);
            if (queue.size() > len){
                sum = sum - queue.poll();
            }
            sum = sum + val;
            return (double) sum / queue.size();
        }
    }

    @Test
    public void test(){
        MovingAverage movingAverage = new MovingAverage(3);
        System.out.println(movingAverage.next(1));
        System.out.println(movingAverage.next(10));
    }
}
