package Leetcode.week.week427;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class Q2 {
    /*
    用点构造面积最大的矩形Ⅰ
     */

    public int maxRectangleArea(int[][] points) {
        int res = -1;

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }else {
                    return o1[0] - o2[0];
                }
            }
        });

        for (int i = 1; i < points.length; i++){
            if (points[i - 1][0] == points[i][0]){
                int x1 = points[i - 1][0], y1 = points[i -1][1];
                int y2 = points[i][1];

                for (int j = i + 1; j < points.length - 1;j++){
                    if (points[j][0] != x1){
                        if (points[j][1] < y1 || points[j][1] > y2){
                            continue;
                        }
                        if (points[j + 1][0] == points[j][0] &&
                                points[j + 1][1] == y2 && points[j][1] == y1){
                            res = Math.max(res, (y2 - y1) * (points[j + 1][0] - x1));
                        }
                        break;
                    }
                }
            }
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(maxRectangleArea(new int[][]{{15,93},{5,33},{15,33},{5,93},{30,93},{30,33},{35,93},{35,33}}));
    }
}
