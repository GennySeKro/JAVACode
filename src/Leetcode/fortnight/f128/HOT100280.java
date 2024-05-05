package Leetcode.fortnight.f128;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class HOT100280 {
    /*
    覆盖所有点的最少矩形数目
     */

    public int minRectanglesToCoverPoints(int[][] points, int w) {
        int res = 0;
        if (w == 0){
            return points.length;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        return count(points, 0, points.length - 1, 0, w);
    }

    private int count(int[][] points, int left, int right, int res, int w) {
        if (left > right){
            return res;
        }
        if (left == right){
            return res + 1;
        }
        if (points[right][0] - points[left][0] <= w){
            return res + 1;
        }
        int nextLeft = left, nextRight = right;
        while (points[nextLeft][0] - points[left][0] <= w){
            nextLeft++;
        }
        while (points[right][0] - points[nextRight][0] <= w){
            nextRight--;
        }
        res = res + 2;
        return count(points, nextLeft, nextRight, res, w);
    }

    @Test
    public void test(){
        System.out.println(minRectanglesToCoverPoints(new int[][]{{1,1},{3,3}}, 2));
    }
}
