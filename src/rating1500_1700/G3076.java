package rating1500_1700;

public class G3076 {
    /*
    数组中的最短非公共子字符串
     */

    public String[] shortestSubstrings(String[] arr) {
        int n = arr.length;
        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            int m = arr[i].length();
            String res = "";
            for (int size = 1; size <= m && res.isEmpty(); size++) {
                for (int j = size; j <= m; j++) {
                    String t = arr[i].substring(j - size, j);
                    if ((res.isEmpty() || t.compareTo(res) < 0) && check(arr, i, t)) {
                        res = t;
                    }
                }
            }
            ans[i] = res;
        }
        return ans;
    }

    private boolean check(String[] arr, int i, String sub) {
        for (int j = 0; j < arr.length; j++) {
            if (j != i && arr[j].contains(sub)) {
                return false;
            }
        }
        return true;
    }
}
