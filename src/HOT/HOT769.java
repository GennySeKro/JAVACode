package HOT;

import org.junit.Test;

public class HOT769 {
    /*
    最多能完成排序的块
     */

    public int maxChunksToSorted(int[] arr) {
        int n = arr.length, ans = 0;
        for (int i = 0, j = 0, min = n, max = -1; i < n; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
            if (j == min && i == max) {
                ans++; j = i + 1; min = n; max = -1;
            }
        }
        return ans;
    }

    @Test
    public void test(){
        System.out.println(maxChunksToSorted(new int[]{4,3,2,1,0}));
    }
}
