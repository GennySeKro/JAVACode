package LCR;

import org.junit.Test;

import java.util.ArrayList;

public class LCR187 {
    /*
    破冰游戏
     */


    public int iceBreakingGame(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int idx = 0;
        while (n > 1) {
            idx = (idx + m - 1) % n;
            list.remove(idx);
            n--;
        }
        return list.get(0);
    }

    public int iceBreakingGame0(int n, int m) {
        int ans = 0;
        // 最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }


    @Test
    public void test(){
        System.out.println(iceBreakingGame(5, 2));
    }
}
