package rating1500_1700;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class G1573 {
    /*
    分割字符串的方案数
     */

    public int numWays(String s) {
        final int MODULO = 1000000007;
        List<Integer> ones = new ArrayList<Integer>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                ones.add(i);
            }
        }
        int m = ones.size();
        if (m % 3 != 0)
            return 0;
        if (m == 0) {
            long ways = (long) (n - 1) * (n - 2) / 2;
            return (int) (ways % MODULO);
        } else {
            int index1 = m / 3, index2 = m / 3 * 2;
            int count1 = ones.get(index1) - ones.get(index1 - 1);
            int count2 = ones.get(index2) - ones.get(index2 - 1);
            long ways = (long) count1 * count2;
            return (int) (ways % MODULO);
        }
    }

    @Test
    public void test(){
        System.out.println(numWays("100100010100110"));
    }
}
