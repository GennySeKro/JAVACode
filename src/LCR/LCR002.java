package LCR;

import org.junit.Test;

public class LCR002 {
    /*
    二进制求和
     */

    public String addBinary(String a, String b) {
        int k = 0;
        StringBuilder stringBuilder = new StringBuilder();
        int i = 1;
        for (;i <= Math.max(a.length(), b.length());i++){
            int aValue = i <= a.length() ? (a.charAt(a.length() - i)) - '0' : 0;
            int bValue = i <= b.length() ? (b.charAt(b.length() - i)) - '0' : 0;
            int res = (aValue + bValue + k) % 2;
            k = (aValue + bValue + k) / 2;
            stringBuilder.append(res);
        }
        if (k == 1){
            stringBuilder.append(1);
            return stringBuilder.reverse().toString();
        }else {
            return stringBuilder.reverse().toString();
        }
    }

    @Test
    public void test(){
        System.out.println(addBinary("1010", "101"));
    }
}
