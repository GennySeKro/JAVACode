package week386;

import org.junit.Test;

public class HOT100225 {
    /*
    求交集区域内的最大正方形面积
     */
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        long res = 0;
        for (int i = 0;i < bottomLeft.length;i++){
            for (int j = i + 1;j < bottomLeft.length;j++){
                int l = Math.max(bottomLeft[i][0], bottomLeft[j][0]);
                int r = Math.min(topRight[i][0], topRight[j][0]);
                int d = Math.max(bottomLeft[i][1], bottomLeft[j][1]);
                int u = Math.min(topRight[i][1], topRight[j][1]);
                if (l <= r && d <= u){
                    int a = Math.min(r - l, u - d);
                    res = Math.max(res, (long)a * a);
                }
            }
        }
        return res;
    }


    @Test
    public void test(){
        System.out.println(largestSquareArea(new int[][]{{1,3},{2,2}}, new int[][]{{3,4},{5,5}}));
    }
}
