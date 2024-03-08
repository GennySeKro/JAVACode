package LCR;

public class LCR128 {
    /*
    库存管理
     */

    public int stockManagement(int[] stock) {
        int left = 0, right = stock.length - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (stock[mid] < stock[right]){
                right = mid;
            } else if (stock[mid] > stock[right]) {
                left = mid + 1;
            }else {
                right = right - 1;
            }
        }
        return stock[left];
    }
}
