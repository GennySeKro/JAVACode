import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class HOT8 {
    /*
    字符串转换整数
     */

    public int myAtoi(String s) {
       if (s.length() == 0){
           return 0;
       }
       int index = 0, n = s.length(), sign = 1;
       Long res = 0L;
       while(index < n && s.charAt(index) == ' '){
           index++;
       }
       if (index < n && (s.charAt(index) == '+' || s.charAt(index) == '-')){
           sign = s.charAt(index) == '+' ? 1 : -1;
           index++;
       }

       while (index < n && s.charAt(index) >= '0' && s.charAt(index) <= '9'){
           res = res * 10 + s.charAt(index) - '0';
           if (res * sign > Integer.MAX_VALUE){
               return Integer.MAX_VALUE;
           } else if (res * sign < Integer.MIN_VALUE) {
               return Integer.MIN_VALUE;
           }else {
               index++;
           }
       }
       return (int) (res * sign);
    }

    @Test
    public void test(){
        System.out.println(myAtoi("9223372036854775808"));
    }
}
