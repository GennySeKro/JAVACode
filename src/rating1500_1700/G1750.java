package rating1500_1700;

import org.junit.Test;

public class G1750 {
    /*
    删除字符串两端相同字符后的最短长度
     */

    public int minimumLength(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right){
            if (s.charAt(left) == s.charAt(right)){
                char temp = s.charAt(left);
                while (true){
                    if (s.charAt(left) == temp){
                        if (left == s.length() - 1){
                            return 0;
                        }
                        left++;
                    }else {
                        break;
                    }
                }
                while (true){
                    if (s.charAt(right) == temp){
                        if (right == 0){
                            return 0;
                        }
                        right--;
                    }else {
                        break;
                    }
                }
            }else {
                return right - left + 1;
            }
        }
        if (left == right){
            return 1;
        }
        return 0;
    }

    @Test
    public void test(){
        System.out.println(minimumLength("aba"));
    }
}
