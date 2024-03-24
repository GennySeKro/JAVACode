package rating1500_1700;

import org.junit.Test;

public class G2571 {
    /*
    将整数减少到零需要的最小操作数
     */

    public int minOperations(int n) {
        int step = 0;
        while (n > 0) {
            if ((n & 3) == 3) {
                n++;
                step++;
            }
            if ((n & 1) == 1) step++;
            n >>= 1;
        }
        return step;
    }

    @Test
    public void test(){
        System.out.println(minOperations(39));
    }
}
