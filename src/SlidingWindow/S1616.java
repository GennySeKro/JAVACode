package SlidingWindow;

import org.junit.Test;

public class S1616 {
    /*
    分割两个字符串得到回文串
     */

    public boolean checkPalindromeFormation(String a, String b) {

        if (a.length() == 1){
            return true;
        }
        return isString(a, b) || isString(b, a);
    }

    private boolean isString(String a, String b) {
        int left = 0, right = a.length() - 1;
        while (left < right && a.charAt(left) == b.charAt(right)){
            left++;
            right--;
        }
        return checkIsPalindrome(a, left, right) || checkIsPalindrome(b, left, right);
    }

    private boolean checkIsPalindrome(String str, int left, int right) {
        while (left < right && str.charAt(left) == str.charAt(right)){
            left++;
            right--;
        }
        return left >= right;
    }

    @Test
    public void test(){
        System.out.println(checkPalindromeFormation("xbdef", "xecab"));
    }
}
