package LCR;

import java.util.HashMap;
import java.util.Map;

public class LCR075 {
    /*
    数组的相对排序
     */

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int index = 0;
        int [] hash = new int [1001];
        for (int n : arr1) {
            hash[n]++;
        }

        for (int n : arr2) {
            while (hash[n]-- > 0) {
                arr1[index++] = n;
            }
        }

        for (int n = 0; n < hash.length; ++n) {
            while (hash[n]-- > 0) {
                arr1[index++] = n;
            }
        }

        return arr1;
    }
}
