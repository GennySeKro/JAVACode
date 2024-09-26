package Leetcode.week.week401;

import org.junit.Test;

public class HOT100325 {
    /*
    找出K秒后拿着球的孩子
     */

    public int numberOfChild(int n, int k) {
        while (k > 2 * (n - 1)){
            k = k - 2 * (n - 1);
        }
        if (k < n){
            return k;
        } else if (k == n) {
            return n - 2;
        } else if (k > n && k < 2 * (n - 1)) {
            return n - (k - n + 1) - 1;
        } else  {
            return 0;
        }
    }

    @Test
    public void test(){
        System.out.println(numberOfChild(2,2));
    }
}
