package Leetcode.fortnight.f159;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Q2 {
    /*
    找到最大三角形面积
     */

    public long maxArea(int[][] coords) {
        // 全局最小/最大 x, y
        int xMin = Integer.MAX_VALUE, xMax = Integer.MIN_VALUE;
        int yMin = Integer.MAX_VALUE, yMax = Integer.MIN_VALUE;
        // xMap: key=x，value=[该 x 对应的最小 y, 最大 y]
        Map<Integer, int[]> xMap = new HashMap<>(), yMap = new HashMap<>();
        for (int[] c : coords) {
            xMin = Math.min(xMin, c[0]);
            xMax = Math.max(xMax, c[0]);
            yMin = Math.min(yMin, c[1]);
            yMax = Math.max(yMax, c[1]);
            // 更新 xMap
            if (!xMap.containsKey(c[0])) {
                xMap.put(c[0], new int[]{c[1], c[1]});  // 初始化 minY = maxY = c[1]
            } else {
                int[] tmp = xMap.get(c[0]);
                tmp[0] = Math.min(tmp[0], c[1]);
                tmp[1] = Math.max(tmp[1], c[1]);
            }
            // 更新 yMap（同理）
            if (!yMap.containsKey(c[1])) {
                yMap.put(c[1], new int[]{c[0], c[0]});
            } else {
                int[] tmp = yMap.get(c[1]);
                tmp[0] = Math.min(tmp[0], c[0]);
                tmp[1] = Math.max(tmp[1], c[0]);
            }
        }
        // 分别计算 x 方向、y 方向的最大两倍面积
        return Math.max(getMax(xMap, xMin, xMax), getMax(yMap, yMin, yMax));
    }

    // map: key=固定坐标值，value=[该直线上点的最小坐标, 最大坐标]
    // min, max：对应另一维度的全局最小/最大
    private long getMax(Map<Integer, int[]> map, int min, int max) {
        long res = -1;
        for (Map.Entry<Integer, int[]> kv : map.entrySet()) {
            int k = kv.getKey();
            int[] v = kv.getValue();
            // 直线上的点不都在同一位置，且该直线不是整体的边界
            if (v[0] != v[1] && (k != min || k != max)) {
                long d1 = v[1] - v[0];                   // 边与轴平行的那条边长
                long d2 = Math.max(k - min, max - k);    // 与另一条边可能的最大跨度
                res = Math.max(res, d1 * d2);            // 两倍面积 = d1 * d2
            }
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(maxArea(new int[][]{{1,1},{1,2},{3,2},{3,3}}));
    }
}
