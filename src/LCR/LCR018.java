package LCR;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LCR018 {
    /*
    验证回文串
     */

    public boolean isPalindrome(String s) {
        List<Character> str = new ArrayList<>();
        for (int i = 0;i < s.length();i++){
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9' || s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                str.add(s.charAt(i));
            } else if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                str.add((char)(s.charAt(i) + 32));
            }
        }
        for (int i = 0;i < str.size() / 2;i++){
            if (str.get(i) != str.get(str.size() - i - 1)){
                return false;
            }
        }
        return true;
    }

    @Test
    public void test(){
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
