package rating1500_1700;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class G3016 {
    /*
    输入单词需要的最少按键次数Ⅱ
     */

    public int minimumPushes(String word) {
        int[] cnt = new int[26];
        for (char b : word.toCharArray()) {
            cnt[b - 'a']++;
        }
        Arrays.sort(cnt);

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            ans += cnt[25 - i] * (i / 8 + 1);
        }
        return ans;
    }
}
