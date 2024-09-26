package SlidingWindow;

import org.junit.Test;

import java.util.Arrays;

public class S1652 {
    /*
    拆炸弹
     */

    public int[] decrypt(int[] code, int k) {

        int[] res = new int[code.length];
        if (k == 0){
            Arrays.fill(res, 0);
            return res;
        }
        int leftNum = 0, rightNum = 0;
        for (int i = 0;i < Math.abs(k);i++){
            rightNum += code[i];
        }
        for (int i = code.length - Math.abs(k);i < code.length;i++){
            leftNum += code[i];
        }

        for (int i = 0;i < code.length;i++){
            if (k > 0){
                rightNum = rightNum + code[(i + k) % code.length] - code[i];
                res[i] = rightNum;
            }else {
                res[i] = leftNum;
                leftNum = leftNum + code[i] - code[(i - Math.abs(k) + code.length) % code.length];
            }
        }

        return res;
    }

    @Test
    public void test(){
        System.out.println(decrypt(new int[]{2,4,9,3}, -2));
    }
}
