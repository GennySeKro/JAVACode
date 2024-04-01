package rating1500_1700;

import java.util.Set;

public class G2249 {
    /*
    统计圆内格点数目
     */

    public int countLatticePoints(int[][] circles) {
        int size = circles.length;
        int len = 201;
        int count = 0;
        for (int i = 0; i < len; i++)
        {
            for (int j = 0; j < len; j++)
            {
                // 点的坐标
                int x = i, y = j;
                for (int k = 0; k < size; k++)
                {
                    int xk = circles[k][0];
                    int yk = circles[k][1];
                    int rk = circles[k][2];
                    if ((x - xk) * (x - xk) + (y - yk) * (y - yk) <= rk * rk)
                    {
                        count++;
                        break;
                    }
                }
            }
        }
        return count;
    }
}
