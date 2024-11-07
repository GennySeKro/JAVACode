package DP;

public class D2320 {
    /*
    统计放置房子的方式数
     */

    static  int MODULO = 1000000007;

    public int countHousePlacements(int n) {
        int prev = 1, curr = 2;
        for (int i = 2; i <= n; i++) {
            int next = (prev + curr) % MODULO;
            prev = curr;
            curr = next;
        }
        return (int) ((long) curr * curr % MODULO);
    }
}
