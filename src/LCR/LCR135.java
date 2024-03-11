package LCR;

import java.util.ArrayList;
import java.util.List;

public class LCR135 {
    /*
    报数
     */

    public int[] countNumbers(int cnt) {
        int[] res = new int[(int)Math.pow(10, cnt) - 1];
        for (int i = 0;i < Math.pow(10, cnt) - 1;i++){
            res[i] = i + 1;
        }
        return res;
    }
}
