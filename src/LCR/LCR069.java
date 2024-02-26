package LCR;

import org.junit.Test;

public class LCR069 {
    /*
    山脉数组的峰顶索引
     */

    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        int res = -1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]){
                res = mid;
                break;
            } else if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(peakIndexInMountainArray(new int[]{24,69,100,99,79,78,67,36,26,19}));
    }
}
