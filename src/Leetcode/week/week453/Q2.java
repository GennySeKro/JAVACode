package Leetcode.week.week453;

public class Q2 {
    /*
    统计计算机解锁顺序排列数
     */

    private static final int mod = 1_000_000_007;

    public int countPermutations(int[] complexity) {
        for (int i = 1; i < complexity.length; i++){
            if (complexity[i] <= complexity[0]){
                return 0;
            }
        }

        long res = 1;
        for (int i = complexity.length - 1; i >= 1; i--){
            res *= i;
            res %= mod;
        }

        return (int) res;
    }
}
