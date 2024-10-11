package SlidingWindow;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class S923 {
    /*
    三数之和的多种可能
     */

    public int threeSumMulti(int[] arr, int target) {
        // arr[i] + arr[j] = target - arr[k];
        int res = 0, n = arr.length, mod = 1_000_000_007;
        for (int i=0;i < n - 2;i++) {
            Map<Integer,Integer> map = new HashMap<>();
            int x = arr[i];
            for (int j = i+1;j < n;j++) {
                int y = arr[j];
                // 如果存在 arr[i] + arr[j] = target - arr[k] 就更新结果
                // arr[i] + arr[j]是之前就存储过的  当前循环arr[k] = y
                res = (res + map.getOrDefault(target - y,0)) % mod;
                // 记录 arr[i] + arr[j] 的数量
                map.merge(x + y,1,Integer::sum);
            }
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(threeSumMulti(new int[]{1,1,2,2,3,3,4,4,5,5}, 8));
    }
}
