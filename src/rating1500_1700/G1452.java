package rating1500_1700;
import java.util.*;

public class G1452 {
    /*
    收藏清单
     */

    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        int n = favoriteCompanies.size();
        Set<String>[] arr = new Set[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new HashSet(favoriteCompanies.get(i));
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (arr[j].containsAll(arr[i])) {
                    flag = false;
                    break;
                }
            }
            if (flag) ans.add(i);
        }

        return ans;
    }
}
