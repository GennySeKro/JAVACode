package HOT;

public class HOT338 {
    /*
    比特位计数
     */

    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        for(int i = 0;i <= n;i++){
            bits[i] = countOnes(i);
        }
        return bits;
    }

    private int countOnes(int x) {
        int ones = 0;
        while(x > 0){
            x &= x-1;
            ones++;
        }
        return ones;
    }
}
