package SlidingWindow;

import org.junit.Test;

public class S2730 {
    /*
    找到最长的半重复子字符串
     */

    public int longestSemiRepetitiveSubstring(String S) {
        char[] s = S.toCharArray();
        int ans = 1, left = 0, same = 0, n = s.length;
        for (int right = 1; right < n; right++) {
            if (s[right] == s[right - 1] && ++same > 1) {
                for (left++; s[left] != s[left - 1]; left++);
                same = 1;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    @Test
    public void test(){
        System.out.println(longestSemiRepetitiveSubstring("0000"));
    }
}
