package Binary;

import org.junit.Test;

public class B1011 {
    /*
    在D天内送达包裹的能力
     */

    public int shipWithinDays(int[] weights, int days) {
        int maxValue = 0;
        int sum = 0;
        for (int num : weights){
            sum += num;
            maxValue = Math.max(maxValue, num);
        }
        int left = maxValue, right = sum;

        while (left <= right){
            int mid = (left + right) >>> 1;
            if (needDays(mid, weights) > days){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        return left;

    }

    private int needDays(int mid, int[] weights) {
        int res = 0, tempValue = 0;
        for (int i = 0;i < weights.length;i++){
            if (tempValue + weights[i] <= mid){
                tempValue += weights[i];
            }else {
                res++;
                tempValue = weights[i];
            }
        }
        if (tempValue != 0){
            return res + 1;
        }

        return res;
    }

    @Test
    public void test(){
        System.out.println(shipWithinDays(new int[]{1,2,3,1,1}, 4));
    }
}
