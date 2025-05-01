package DataStructure.Enum;

import java.util.HashMap;

public class E2001 {
    /*
    可互换矩形的数组
     */

    public long interchangeableRectangles(int[][] rectangles) {
        long res = 0L;
        HashMap<Double, Integer> map = new HashMap<>();
        for (int i = rectangles.length - 1;i >= 0; i--){
            double temp = (double) (rectangles[i][0] * 1.0) / rectangles[i][1];
            if (map.containsKey(temp)){
                res += map.get(temp);
            }
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }

        return res;
    }
}
