package HOT;

public class HOT29 {
    /*
    两数相除
     */

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        if (dividend == Integer.MIN_VALUE && divisor == 1){
            return Integer.MIN_VALUE;
        }
        if (dividend > 0){
            return -divide(-dividend, divisor);
        }
        if (divisor > 0){
            return -divide(dividend, -divisor);
        }
        if (dividend > divisor){
            return 0;
        }
        int res = 1, temp = divisor;
        while ((dividend - divisor) <= divisor){
            res = res + res;
            divisor = divisor + divisor;
        }
        return res + divide(dividend - divisor, temp);
    }
}
