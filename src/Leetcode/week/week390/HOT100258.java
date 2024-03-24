package Leetcode.week.week390;

import org.junit.Test;

import java.util.*;

public class HOT100258 {
    /*
    最高频率的 ID
     */

    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        int len = nums.length;
        Map<Integer, Long> countMap = new HashMap<>();
        TreeMap<Long, Integer> freqMap = new TreeMap<>();
        freqMap.put(0L, 0);
        long[] res = new long[len];
        for (int i = 0; i < len; ++i) {
            int n = nums[i], f = freq[i];
            long oldFreq = countMap.getOrDefault(n, 0L);
            if (oldFreq != 0) {
                int ct = freqMap.get(oldFreq);
                if (ct == 1) {
                    freqMap.remove(oldFreq);
                } else {
                    freqMap.put(oldFreq, ct - 1);
                }
            }
            oldFreq += f;
            countMap.put(n, oldFreq);
            freqMap.put(oldFreq, freqMap.getOrDefault(oldFreq, 0) + 1);
            res[i] = freqMap.lastKey();
        }
        return res;
    }
}
