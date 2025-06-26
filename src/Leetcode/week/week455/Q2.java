package Leetcode.week.week455;

import java.util.ArrayList;
import java.util.List;

public class Q2 {
    /*
    硬币面值还原
     */

    public List<Integer> findCoins(int[] numWays) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 1; i <= numWays.length; i++){
            if (numWays[i - 1] == 1 && res.isEmpty()){
                res.add(i);
            }else {
                int[] dp = new int[i + 1];
                dp[0] = 1;
                for (int d : res){
                    for (int j = d; j <= i; j++){
                        dp[j] += dp[j - d];
                    }
                }

                if (dp[i] == numWays[i - 1] - 1){
                    res.add(i);
                } else if (dp[i] != numWays[i - 1]) {
                    return new ArrayList<>();
                }
            }
        }

        return res;
    }
}
