package Leetcode.week.week451;

import org.junit.Test;

public class Q1 {
    /*
    木材运输的最小成本
     */

    public long minCuttingCost(int n, int m, int k) {
        int min = Math.min(n, m);
        int max = Math.max(n, m);

        long res = Long.MAX_VALUE;
        if (max <= k){
            return 0;
        }

        if (min <= k && max > k){
            for (int i = 1; i < max / 2 + 1; i++){
                if (i > k || max - i > k){
                    continue;
                }
                res = Math.min(res, (long) i * (max - i));
            }
        }

        return res;

    }

    @Test
    public void test(){
        System.out.println(minCuttingCost(1,4,2));
    }
}
