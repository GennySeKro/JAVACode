package SlidingWindow;

import org.junit.Test;

public class S2105 {
    /*
    给植物浇水
     */

    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int ans = 0;
        int a = capacityA;
        int b = capacityB;
        int i = 0;
        int j = plants.length - 1;
        while (i < j) {
            // Alice 给植物 i 浇水
            if (a < plants[i]) {
                // 没有足够的水，重新灌满水罐
                ans++;
                a = capacityA;
            }
            a -= plants[i++];
            // Bob 给植物 j 浇水
            if (b < plants[j]) {
                // 没有足够的水，重新灌满水罐
                ans++;
                b = capacityB;
            }
            b -= plants[j--];
        }
        // Alice 和 Bob 到达同一株植物，那么当前水罐中水更多的人会给这株植物浇水
        if (i == j && Math.max(a, b) < plants[i]) {
            // 没有足够的水，重新灌满水罐
            ans++;
        }
        return ans;
    }

    @Test
    public void test(){
        System.out.println(minimumRefill(new int[]{1,2,4,4,5}, 6, 5));
    }
}
