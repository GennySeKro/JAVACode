package HOT;

import org.junit.Test;

public class HOT43 {
    /*
    字符串相乘
     */

    public String multiply(String num1, String num2) {
        if (num1.length() == 1 && num2.length() == 1){
            return String.valueOf((num1.charAt(0)-'0')*(num2.charAt(0)-'0'));
        }
        if (num1.length() < num2.length()){
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        int len = (num1.length() + 1) * (num2.length() + 1);
        int[][] res = new int[num2.length()][len];
        int sign = 0;
        for (int i = num2.length()-1;i >= 0;i--){
            int k = 0, index = 0;
            for (int j = num1.length()-1;j >= 0;j--){
                int multi = (num2.charAt(i) - '0')*(num1.charAt(j) - '0');
                if (j == num1.length() - 1){
                    k = multi / 10;
                    res[i][len - num2.length() + i - num1.length() + j + 1] = multi % 10;
                }else {
                    res[i][len - num2.length() + i - num1.length() + j + 1] = (multi + k) % 10;
                    k = (multi + k) / 10;
                }
                index = len - num2.length() + i - num1.length() + j + 1;
            }
            if (k != 0){
                res[i][index - 1] = k;
            }
        }
        int[] result = new int[len];
        int k = 0;
        for (int i = len - 1;i >= 0;i--){
            int sum = 0;
            for (int j = 0;j < num2.length();j++){
                sum = sum + res[j][i];
            }
            result[i] = (sum + k) % 10;
            k = (sum + k) / 10;
        }
        StringBuilder str = new StringBuilder();
        if (result.length == 1){
            return String.valueOf(result[0]);
        }
        int flag = 0;
        for (int i = 0;i < result.length;i++){
            if (flag == 1){
                str.append(result[i]);
            }else {
                if (result[i] != 0){
                    str.append(result[i]);
                    flag = 1;
                }
            }
        }
        if (flag == 0){
            return "0";
        }
        return str.toString();
    }

    @Test
    public void test(){
        System.out.println(multiply("9133","0"));
    }
}
