package rating1500_1700;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class G792 {
    /*
    匹配子序列的单词数
     */

    public int numMatchingSubseq(String s, String[] words) {
        int n = s.length(), ans = 0;
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = map.getOrDefault(s.charAt(i), new ArrayList<>());
            list.add(i);
            map.put(s.charAt(i), list);
        }
        for (String w : words) {
            boolean ok = true;
            int m = w.length(), idx = -1;
            for (int i = 0; i < m && ok; i++) {
                List<Integer> list = map.getOrDefault(w.charAt(i), new ArrayList<>());
                int l = 0, r = list.size() - 1;
                while (l < r) {
                    int mid = l + r >> 1;
                    if (list.get(mid) > idx) r = mid;
                    else l = mid + 1;
                }
                if (r < 0 || list.get(r) <= idx) ok = false;
                else idx = list.get(r);
            }
            if (ok) ans++;
        }
        return ans;
    }

    @Test
    public void test(){
        System.out.println(numMatchingSubseq("dsahjpjauf", new String[]{"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"}));
    }
}
