package rating1500_1700;
import java.util.*;

public class G1263 {
    /*
    搜索推荐系统
     */

    int[][] tr = new int[20010][26];
    int idx = 0;
    Map<Integer, Integer> min = new HashMap<>(), max = new HashMap<>();
    void add(String s, int num) {
        int p = 0;
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (tr[p][u] == 0) {
                tr[p][u] = ++idx;
                min.put(tr[p][u], num);
            }
            max.put(tr[p][u], num);
            p = tr[p][u];
        }
    }
    int[] query(String s) {
        int a = -1, b = -1, p = 0;
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (tr[p][u] == 0) return new int[]{-1, -1};
            a = min.get(tr[p][u]); b = max.get(tr[p][u]);
            p = tr[p][u];
        }
        return new int[]{a, b};
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < products.length; i++) add(products[i], i);
        for (int i = 0; i < searchWord.length(); i++) {
            List<String> list = new ArrayList<>();
            int[] info = query(searchWord.substring(0, i + 1));
            int l = info[0], r = info[1];
            for (int j = l; j <= Math.min(l + 2, r) && l != -1; j++) list.add(products[j]);
            ans.add(list);
        }
        return ans;
    }
}
