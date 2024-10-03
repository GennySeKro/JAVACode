package SlidingWindow;

import org.junit.Test;

public class S3258 {
    /*
    统计满足K约束的子字符串数量Ⅰ
     */

    public int countKConstraintSubstrings(String s, int k) {
        if (s.length() == 1){
            return 1;
        }

        int res = 0, zeroNum = 0, oneNum = 0;
        int right = 0, left = 0;

        while (right < s.length()){
            if (s.charAt(right) == '1'){
                oneNum++;
            }else {
                zeroNum++;
            }

            while (zeroNum > k && oneNum > k){
                if (s.charAt(left) == '1'){
                    oneNum--;
                }else {
                    zeroNum--;
                }
                left++;
            }

            res += right - left + 1;
            right++;
        }

        return res;
    }


    @Test
    public void test(){
        System.out.println(countKConstraintSubstrings("11111", 1));
    }
}
