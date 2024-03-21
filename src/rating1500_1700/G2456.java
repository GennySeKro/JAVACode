package rating1500_1700;
import java.util.*;

public class G2456 {
    /*
    最流行的视频创作者
     */

    List<List<String>> ans = new ArrayList<>();
    Map<String, List<String[]>> mp = new HashMap<>();
    Map<String, Long> cnt = new HashMap<>();
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        int n = creators.length;
        long maxv = 0;
        for (int i = 0; i < n; i++) {
            if (cnt.containsKey(creators[i])) {
                cnt.put(creators[i], cnt.get(creators[i]) + views[i]);
                mp.get(creators[i]).add(new String[]{ids[i], views[i]+""});
            } else {
                List<String[]> list = new ArrayList<>();
                list.add(new String[]{ids[i], views[i]+""});
                cnt.put(creators[i], (long)views[i]);
                mp.put(creators[i], list);
            }
            maxv = Math.max(maxv, cnt.get(creators[i]));
        }
        List<String> mkey = new ArrayList<>();
        for (String key : mp.keySet()) {
            if (cnt.get(key) == maxv) {
                List<String[]> list = mp.get(key);
                Collections.sort(list, (a, b)-> {
                    if (b[1].equals(a[1])) return a[0].compareTo(b[0]);
                    return Integer.valueOf(b[1]).compareTo(Integer.valueOf(a[1]));
                });
                ans.add(Arrays.asList(key, list.get(0)[0]));
            }
        }

        return ans;
    }
}
