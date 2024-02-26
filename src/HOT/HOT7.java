package HOT;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class HOT7 {
    /*
    整数反转
     */

    public int reverse(int x) {
        int k = x;
        Queue<Integer> queue = new LinkedList<>();
        while(x != 0){
            queue.offer(x % 10);
            x = x / 10;
        }
        double res = 0;
        while(!queue.isEmpty()){
            res = res * 10 + queue.poll();
        }
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE){
            return 0;
        }else {
            return (int) res;
        }

    }

    @Test
    public void test(){
        System.out.println(reverse(-123));
    }
}
