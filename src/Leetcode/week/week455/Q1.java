package Leetcode.week.week455;

import java.util.HashMap;
import java.util.HashSet;

public class Q1 {
    /*
    检查元素频次是否为质数
     */

    public boolean checkPrimeFrequency(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();

        int oddNum = 0;

        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > 1 && isOddNumber(map.get(num))){
                set.add(num);
            }else {
                set.remove(num);
            }
        }

        return !set.isEmpty();
    }

    private boolean isOddNumber(int num) {
        if (num == 0 || num == 1){
            return false;
        }
        if (num == 2){
            return true;
        }
        for (int i = 2; i < num; i++){
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }

    /*
    时间复杂度：O(n*n)
    空间复杂度：O(n)
     */
}
