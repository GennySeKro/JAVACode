package rating1500_1700;

import java.util.ArrayList;
import java.util.List;

public class G2970 {
    /*
    统计移除递增子数组的数目Ⅰ
     */

    public int incremovableSubarrayCount(int[] a) {
        int n = a.length;
        int i = 0;
        while (i < n - 1 && a[i] < a[i + 1]) {
            i++;
        }
        if (i == n - 1) { // 每个非空子数组都可以移除
            return n * (n + 1) / 2;
        }

        int ans = i + 2;
        for (int j = n - 1; j == n - 1 || a[j] < a[j + 1]; j--) {
            while (i >= 0 && a[i] >= a[j]) {
                i--;
            }
            ans += i + 2;
        }
        return ans;
    }
}
