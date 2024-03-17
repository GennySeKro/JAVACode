package LCR;

import org.junit.Test;

import java.util.Arrays;

public class LCR179 {
    /*
    查找总价格为目标值的两个商品
     */

    public int[] twoSum(int[] price, int target) {
        int left = 0, right = price.length - 1;
        while (left != right){
            if (price[left] + price[right] == target){
                return new int[]{price[left], price[right]};
            } else if (price[left] + price[right] > target) {
                right = right - 1;
            }else {
                left = left + 1;
            }
        }
        return new int[0];
    }

    @Test
    public void test(){
        System.out.println(Arrays.toString(twoSum(new int[]{3, 9, 12, 15}, 18)));
    }
}
