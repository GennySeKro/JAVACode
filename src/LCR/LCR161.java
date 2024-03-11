package LCR;

import org.junit.Test;

public class LCR161 {
    /*
    连续天数的最高消费额
     */

    public int maxSales(int[] sales) {
        int[] res = new int[sales.length];
        res[0] = sales[0];
        int max = res[0];
        for (int i = 1;i < sales.length;i++){
            if (sales[i] >= 0){
                if (res[i - 1] < 0){
                    res[i] = sales[i];
                }else {
                    res[i] = res[i - 1] + sales[i];
                }
            }else {
                if (res[i - 1] < 0){
                    res[i] = sales[i];
                }else {
                    res[i] = res[i - 1] + sales[i];
                }
            }
            max = Math.max(max, res[i]);
        }
        return max;
    }

    @Test
    public void test(){
        System.out.println(maxSales(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
