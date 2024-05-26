package Leetcode.week.week399;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HOT100321 {
    /*
    优质数对的总数Ⅱ
     */

    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        Map<Integer, Integer> count2 = new HashMap<>();
        for (int num : nums2) {
            count2.put(num, count2.getOrDefault(num, 0) + 1);
        }

        long totalPairs = 0;
        for (int num1 : nums1) {
            int target = num1 / k;
            if (num1 % k == 0) {
                for (int divisor = 1; divisor * divisor <= target; divisor++) {
                    if (target % divisor == 0) {
                        totalPairs += count2.getOrDefault(divisor, 0);
                        if (divisor != target / divisor) {
                            totalPairs += count2.getOrDefault(target / divisor, 0);
                        }
                    }
                }
            }
        }

        return totalPairs;
    }
}
