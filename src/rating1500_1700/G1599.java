package rating1500_1700;

import org.junit.Test;

public class G1599 {
    /*
    经营摩天轮的最大利润
     */

    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        //preSum:当前上过摩天轮的人数   wait:等待上摩天轮的人数
        int n = customers.length, preSum = 0, wait = 0;
        //max:最大利润  ans:最大利润对应的轮数
        int max = 0, ans = -1;
        int i = 0;
        while (i < n || wait > 0) {
            if (i < n) {
                wait += customers[i];
            }
            preSum += Math.min(wait, 4);
            wait = wait >= 4 ? wait - 4 : 0;
            int curProfit = preSum * boardingCost - runningCost * (i + 1);
            if (max < curProfit) {
                max = curProfit;
                ans = i + 1;
            }
            i++;
        }
        return ans;
    }

    @Test
    public void test(){
        System.out.println(minOperationsMaxProfit(new int[]{21,1,38,42,33,16,26,26,49,3,31,37,7,43,18,46,44,27,42,16,15,29,17,7,50,20}, 5, 6));
    }
}
