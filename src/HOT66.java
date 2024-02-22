import org.junit.Test;

import java.util.Arrays;

public class HOT66 {
    /*
    加一
     */

    public int[] plusOne(int[] digits) {
        if (digits[digits.length - 1] + 1 <= 9){
            digits[digits.length - 1] += 1;
            return digits;
        }else {
            int[] res = new int[digits.length + 1];
            int sum = digits[digits.length - 1] + 1;
            res[digits.length] = sum % 10;
            int k = sum / 10;
            for (int i = digits.length - 1;i >= 0;i--){
                if (i == 0){
                    res[i] = k;
                }else {
                    res[i] = (digits[i - 1] + k) % 10;
                    k = (digits[i - 1] + k) / 10;
                }
            }
            if (res[0] != 0){
                return res;
            }else {
                return Arrays.copyOfRange(res, 1, res.length);
            }
        }
    }

    @Test
    public void test(){
        System.out.println(Arrays.toString(plusOne(new int[]{7, 9, 9})));
    }
}
