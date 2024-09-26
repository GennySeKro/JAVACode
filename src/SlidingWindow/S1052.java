package SlidingWindow;

import org.junit.Test;

public class S1052 {
    /*
    爱生气的书店老板
     */

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int sum = 0, tempSum = 0, customersNum = 0;
        int res = Integer.MIN_VALUE;

        for (int i = 0;i < customers.length;i++){
            if (grumpy[i] == 0){
                sum += customers[i];
            }
        }

        for (int i = 0;i < customers.length;i++){
            if (i < minutes){
                customersNum += customers[i];
                if (grumpy[i] == 0){
                    tempSum += customers[i];
                }
            }else {
                res = Math.max(res, sum - tempSum + customersNum);
                customersNum = customersNum - customers[i - minutes] + customers[i];
                if (grumpy[i - minutes] == 0){
                    tempSum = tempSum - customers[i -minutes];
                }
                if (grumpy[i] == 0){
                    tempSum += customers[i];
                }
            }
            res = Math.max(res, sum - tempSum + customersNum);
        }

        return res;
    }

    @Test
    public void test(){
        System.out.println(maxSatisfied(new int[]{1,0,1,2,1,1,7,5}, new int[]{0,1,0,1,0,1,0,1}, 3));
    }
}
