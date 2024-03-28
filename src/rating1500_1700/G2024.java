package rating1500_1700;

import org.junit.Test;

public class G2024 {
    /*
    考试的最大困扰度
     */

    String s;
    int n, k;
    public int maxConsecutiveAnswers(String answerKey, int _k) {
        s = answerKey;
        n = s.length(); k = _k;
        return Math.max(getCnt('T'), getCnt('F'));
    }
    int getCnt(char c) {
        int ans = 0;
        for (int i = 0, j = 0, cnt = 0; i < n; i++) {
            if (s.charAt(i) == c) cnt++;
            while (cnt > k) {
                if (s.charAt(j) == c) cnt--;
                j++;
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }

    @Test
    public void test(){
        System.out.println(maxConsecutiveAnswers("TTFTTFTT", 1));
    }
}
