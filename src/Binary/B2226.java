package Binary;

import org.junit.Test;

public class B2226 {
    /*
    每个小孩最多能分到多少糖果
     */

    public int maximumCandies(int[] candies, long k) {
        int maxCandy = 0, minCandy = 1;
        for (int candy : candies){
            maxCandy = Math.max(maxCandy, candy);
        }

        while (minCandy <= maxCandy){
            int midCandy = (minCandy + maxCandy) >>> 1;
            if (isMaxCandy(midCandy, candies, k)){
                minCandy = midCandy + 1;
            }else {
                maxCandy = midCandy - 1;
            }
        }

        return maxCandy;
    }

    private boolean isMaxCandy(int midCandy, int[] candies, long k) {
        long res = 0;
        for (int candy : candies){
            if (candy == midCandy){
                res++;
            } else if (candy > midCandy) {
                res += candy / midCandy;
            }
        }

        return res >= k;
    }

    @Test
    public void test(){
        System.out.println(maximumCandies(new int[]{5,8,6}, 3));
    }
}
