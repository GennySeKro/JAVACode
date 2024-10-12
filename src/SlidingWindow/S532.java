package SlidingWindow;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class S532 {
    /*
    数组中的k-diff数对
     */

    public int findPairs(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums){
           map.put(num, map.getOrDefault(num, 0) + 1);
        }
        if (k == 0){
            for (Map.Entry<Integer, Integer> entry : map.entrySet()){
                if (entry.getValue() > 1){
                    res++;
                }
            }
            return res;
        }
        for (int num : nums){
            if (map.get(num) == 0){
                continue;
            }
            if (map.getOrDefault(num + k, 0) > 0){
                res++;
            }
            if (map.getOrDefault(num - k, 0) > 0){
                res++;
            }
            map.put(num , 0);
        }

        return res;
    }

    @Test
    public void test(){
        System.out.println(findPairs(new int[]{6,3,5,7,2,3,3,8,2,4}, 2));
    }
}
