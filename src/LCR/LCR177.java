package LCR;

public class LCR177 {
    /*
    撞色搭配
     */

    public int[] sockCollocation(int[] sockets) {
        int ret = 0;
        for (int n : sockets) {
            ret ^= n;
        }
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }
        int a = 0, b = 0;
        for (int n : sockets) {
            if ((div & n) != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }
}
