package Leetcode.week.week385;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class HOT100217 {
    /*
    出现频率最高的素数
     */

    private static final int[][] DIRS = {{1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}};

    public int mostFrequentPrime(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int[] d : DIRS) {
                    int x = i + d[0];
                    int y = j + d[1];
                    int v = mat[i][j];
                    while (x >= 0 && x < m && y >= 0 && y < n) {
                        v = v * 10 + mat[x][y];
                        if (isPrime(v)) {
                            cnt.merge(v, 1, Integer::sum);
                        }
                        x += d[0];
                        y += d[1];
                    }
                }
            }
        }

        int ans = -1;
        int maxCnt = 0;
        for (Map.Entry<Integer, Integer> e : cnt.entrySet()) {
            int v = e.getKey();
            int c = e.getValue();
            if (c > maxCnt) {
                ans = v;
                maxCnt = c;
            } else if (c == maxCnt) {
                ans = Math.max(ans, v);
            }
        }
        return ans;
    }

    private boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test(){
        System.out.println(mostFrequentPrime(new int[][]{{9,3,8},{4,2,5},{3,8,6}}));
    }
}
