package week383;

public class HOT3030 {
    /*
    找出网格的区域平均强度
     */

    public int[][] resultGrid(int[][] image, int threshold) {
        int m = image.length;
        int n = image[0].length;
        int[][] result = new int[m][n];
        int[][] cnt = new int[m][n];
        for (int i = 2; i < m; i++) {
            next:
            for (int j = 2; j < n; j++) {
                // 检查左右相邻格子
                for (int x = i - 2; x <= i; x++) {
                    if (Math.abs(image[x][j - 2] - image[x][j - 1]) > threshold || Math.abs(image[x][j - 1] - image[x][j]) > threshold) {
                        continue next; // 不合法，下一个
                    }
                }

                // 检查上下相邻格子
                for (int y = j - 2; y <= j; ++y) {
                    if (Math.abs(image[i - 2][y] - image[i - 1][y]) > threshold || Math.abs(image[i - 1][y] - image[i][y]) > threshold) {
                        continue next; // 不合法，下一个
                    }
                }

                // 合法，计算 3x3 子网格的平均值
                int avg = 0;
                for (int x = i - 2; x <= i; x++) {
                    for (int y = j - 2; y <= j; y++) {
                        avg += image[x][y];
                    }
                }
                avg /= 9;

                // 更新 3x3 子网格内的 result
                for (int x = i - 2; x <= i; x++) {
                    for (int y = j - 2; y <= j; y++) {
                        result[x][y] += avg; // 先累加，最后再求平均值
                        cnt[x][y]++;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (cnt[i][j] == 0) { // (i,j) 不属于任何子网格
                    result[i][j] = image[i][j];
                } else {
                    result[i][j] /= cnt[i][j]; // 求平均值
                }
            }
        }
        return result;
    }
}
