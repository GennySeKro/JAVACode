package LCR;

public class LCR133 {
    /*
    位1的个数
     */

    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0;i < 32;i++){
            int temp = n >> 1;
            temp = temp << 1;
            if (n - temp == 1){
                res++;
            }
            n = n >> 1;
        }
        return res;
    }
}
