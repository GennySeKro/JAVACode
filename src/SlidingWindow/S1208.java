package SlidingWindow;

import org.junit.Test;

public class S1208 {
    /*
    尽可能使得字符串相等
     */

    public int equalSubstring(String s, String t, int maxCost) {
        int res = Integer.MIN_VALUE;
        int left = 0, right = 0;
        while (right < Math.min(s.length(), t.length())){
            int value = Math.abs(s.charAt(right) - t.charAt(right));
            if (value <= maxCost){
                maxCost -= value;
                right++;
            }else {
                if (left == right){
                    left++;
                    right++;
                }else {
                    res = Math.max(res, right - left);
                    maxCost += Math.abs(s.charAt(left) - t.charAt(left));
                    left++;
                }
            }
        }
        res = Math.max(res, right - left);
        return res == Integer.MIN_VALUE ? 0 : res;
    }

    @Test
    public void test(){
        System.out.println(equalSubstring("krpgjbjjznpzdfy", "nxargkbydxmsgby", 14));
    }
}
