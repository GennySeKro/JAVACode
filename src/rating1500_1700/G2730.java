package rating1500_1700;

import org.junit.Test;

public class G2730 {
    /*
    找到最长的半重复子字符串
     */

    public int longestSemiRepetitiveSubstring(String s) {
        if (s.length() == 1){
            return 1;
        }
        int res = Integer.MIN_VALUE;
        int len = 1;
        int index = 0;
        boolean flag = false;
        for (int i = 0;i < s.length() - 1;){
            if (s.charAt(i + 1) == s.charAt(i) && !flag){
                flag = true;
                index = i + 1;
                len++;
                i++;
                continue;
            }
            if (s.charAt(i + 1) == s.charAt(i) && flag){
                res = Math.max(res, len);
                i = index;
                flag = false;
                len = 1;
                continue;
            }
            len++;
            i++;
        }
        return Math.max(res, len);
    }

    @Test
    public void test(){
        System.out.println(longestSemiRepetitiveSubstring("0001"));
    }
}
