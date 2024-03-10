package LCR;

import java.util.ArrayList;
import java.util.List;

public class LCR019 {
    /*
    验证回文串Ⅱ
     */

    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        int swap=2;
        while (left <=right) {
            while (s.charAt(left) != s.charAt(right)&&left<=right) {
                if(swap==2){
                    left++;
                }else if(swap==1){
                    right--;
                    left--;
                }else{
                    return false;
                }
                swap--;
            }
            left++;
            right--;
        }
        return true;
    }
}
