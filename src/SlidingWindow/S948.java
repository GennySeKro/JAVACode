package SlidingWindow;

import org.junit.Test;

import java.util.Arrays;

public class S948 {
    /*
    令牌放置
     */

    public int bagOfTokensScore(int[] tokens, int power) {
        int res = 0, tempValue = 0;
        Arrays.sort(tokens);
        int left = 0, right = tokens.length - 1;

        while (left <= right){
            if (power >= tokens[left]){
                power -= tokens[left];
                tempValue++;
                left++;
            }else {
                if (tempValue > 0){
                    power += tokens[right];
                    right--;
                    tempValue--;
                }else {
                    break;
                }
            }

            res = Math.max(res, tempValue);
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(bagOfTokensScore(new int[]{71,55,82}, 54));
    }
}
