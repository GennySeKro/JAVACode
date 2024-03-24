package rating1500_1700;

import org.junit.Test;

public class G2384 {
    /*
    最大回文数字
     */

    public String largestPalindromic(String num) {
        int[] number = new int[10];
        for (int i = 0;i < num.length();i++){
            number[num.charAt(i) - '0']++;
        }
        StringBuilder res = new StringBuilder();
        for (int i = 9;i >= 0;i--){
            if (i == 0 && res.length() == 0){
                break;
            }
            while (number[i] >= 2){
                res.append(i);
                number[i] = number[i] - 2;
            }
        }
        String left = res.toString();
        for (int i = 9;i >= 0;i--){
            if (number[i] != 0){
                return left + i + res.reverse();
            }
        }
        return left + res.reverse().toString();
    }


    @Test
    public void test(){
        System.out.println(largestPalindromic("00009"));
    }
}
