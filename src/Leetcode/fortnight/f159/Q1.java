package Leetcode.fortnight.f159;

import java.util.ArrayList;

public class Q1 {
    /*
    最小相邻交换至奇偶交替
     */

    public int minSwaps(int[] nums) {

        ArrayList<Integer> evens = new ArrayList<>();
        ArrayList<Integer> odds = new ArrayList<>();

        for (int i = 0; i < nums.length; i++){
            if (nums[i] % 2 == 0){
                evens.add(i);
            }else {
                odds.add(i);
            }
        }

        long ans = Long.MAX_VALUE;
        //在偶数位置放置偶数
        if (evens.size() == (nums.length + 1) / 2 && odds.size() == nums.length / 2){
            ans = Math.min(ans, calc(evens));
        }

        //在偶数位置放奇数
        if (odds.size() == (nums.length + 1) / 2 && evens.size() == nums.length / 2){
            ans = Math.min(ans, calc(odds));
        }

        return ans == Long.MAX_VALUE ? -1 : (int) ans;
    }

    private long calc(ArrayList<Integer> list) {
        long res = 0;
        for (int i = 0; i < list.size(); i++){
            res += Math.abs(list.get(i) - 2 * i);
        }

        return res;
    }
}
