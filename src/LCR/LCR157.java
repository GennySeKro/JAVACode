package LCR;

import org.junit.Test;

import java.util.*;

public class LCR157 {
    /*
    套餐内商品的排序顺序
     */

    int N = 10;
    Set<String> set = new HashSet<>();
    boolean[] vis = new boolean[N];
    public String[] goodsOrder(String s) {
        char[] cs = s.toCharArray();
        dfs(cs, 0, "");
        String[] ans = new String[set.size()];
        int idx = 0;
        for (String str : set) ans[idx++] = str;
        return ans;
    }
    void dfs(char[] cs, int u, String cur) {
        int n = cs.length;
        if (u == n) {
            set.add(cur);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                vis[i] = true;
                dfs(cs, u + 1, cur + String.valueOf(cs[i]));
                vis[i] = false;
            }
        }
    }


    @Test
    public void test(){
        System.out.println(Arrays.toString(goodsOrder("agew")));
    }
}
