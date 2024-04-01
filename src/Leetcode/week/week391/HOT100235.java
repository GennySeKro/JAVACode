package Leetcode.week.week391;

import org.junit.Test;

public class HOT100235 {
    /*
    换水问题
     */

    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int ans = 0;
        int empty = 0;
        while (numBottles != 0 || empty != 0){
            ans = ans + numBottles;
            empty = empty + numBottles;
            if (empty >= numExchange){
                numBottles = 1;
                empty = empty - numExchange;
                numExchange++;
            }else {
                break;
            }
        }
        return ans;
    }

    @Test
    public void test(){
        System.out.println(maxBottlesDrunk(10,3));
    }
}
