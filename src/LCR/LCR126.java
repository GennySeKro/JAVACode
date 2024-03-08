package LCR;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LCR126 {
    /*
    斐波那契数
     */

    Map<Integer, Integer> map = new HashMap<>();
    public int fib(int n) {
        if (n == 0){
            return 0;
        } else if (n == 1) {
            return 1;
        }
        map.put(0,0);
        map.put(1,1);
        for (int i = 2;i <= n;i++){
            int sum = (map.get(i - 1) + map.get(i - 2)) % 1000000007;
            map.put(i, sum);
        }
        return map.get(n);
    }

    @Test
    public void test(){
        System.out.println(fib(4));
    }
}
