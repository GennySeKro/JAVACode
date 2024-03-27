package rating1500_1700;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

public class G1578 {
    /*
    使绳子变成彩色的最短时间
     */

    public int minCost(String colors, int[] neededTime) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0, j = 1; j < colors.length();){
            if (colors.charAt(i) == colors.charAt(j)){
                if (neededTime[i] > neededTime[j]){
                    res = res + neededTime[j];
                    j++;
                }else {
                    res = res + neededTime[i];
                    i = j;
                    j++;
                }
            }else {
                while (!stack.isEmpty() && colors.charAt(stack.peek()) == colors.charAt(i)){
                    if (neededTime[stack.peek()] > neededTime[i]){
                        res = res + neededTime[i];
                        i = stack.peek();
                        stack.pop();
                    }else {
                        res = res + neededTime[stack.pop()];
                    }
                }
                stack.push(i);
                i = j;
                j++;
            }
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(minCost("abaac", new int[]{1,2,3,4,5}));
    }
}
