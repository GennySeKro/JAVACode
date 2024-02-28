package LCR;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LCR060 {
    /*
    前k哥高频元素
     */

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0;i < nums.length;i++){
            if (map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            }else {
                map.put(nums[i], 1);
            }
        }
        int[] res = new int[k];
        for (int i = 0;i < k;i++){
            int max = Integer.MIN_VALUE;
            int maxKey = 0;
            for (Integer key : map.keySet()){
                if (max < map.get(key)){
                    max = map.get(key);
                    maxKey = key;
                }

            }
            res[i] = maxKey;
            map.remove(maxKey);
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(topKFrequent(new int[]{1,1,1,2,2,3}, 2));
    }
}
