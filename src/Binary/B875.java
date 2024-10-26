package Binary;

import org.junit.Test;

public class B875 {
    /*
    爱吃香蕉的珂珂
     */

    public int minEatingSpeed(int[] piles, int h) {
        int maxValue = 0;
        for (int pile : piles){
            maxValue = Math.max(maxValue, pile);
        }

        int minValue = 1, res = maxValue;
        while (minValue <= maxValue){
            int midValue = minValue + ((maxValue - minValue) >>> 1);
            long time = check(midValue, piles);
            if (time > h){
                minValue = midValue + 1;
            }else {
                maxValue = midValue - 1;
                res = Math.min(res, midValue);
            }
        }
        
        return res;
    }

    private long check(int midvalue, int[] piles) {
        long res = 0L;
        for (int pile : piles){
           if (pile <= midvalue){
               res++;
           }else {
               if (pile % midvalue != 0){
                   res += pile / midvalue + 1;
               }else {
                   res += pile / midvalue;
               }
           }
        }

        return res;
    }

    @Test
    public void test(){
        System.out.println(minEatingSpeed(new int[]{805306368,805306368,805306368}, 1000000000));
    }
}
