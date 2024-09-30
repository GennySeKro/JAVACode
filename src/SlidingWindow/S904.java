package SlidingWindow;

import java.util.HashMap;

public class S904 {
    /*
    水果成篮
     */

    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int res = 1, tempSum = 0;
        while (right < fruits.length){
            if (map.containsKey(fruits[right]) || map.size() < 2){
                map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
                tempSum++;
                right++;
            }else {
                res = Math.max(res, tempSum);
                while (map.size() == 2){
                    map.put(fruits[left], map.get(fruits[left]) - 1);
                    tempSum--;
                    if (map.get(fruits[left]) == 0){
                        map.remove(fruits[left]);
                    }
                    left++;
                }
            }
        }
        res = Math.max(res, tempSum);

        return res;
    }
}
