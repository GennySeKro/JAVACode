package HOT;

import java.util.Arrays;

public class HOT455 {
    /*
    分发饼干
     */

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int index = 0;
        for(int i = 0;i < s.length;i++){
            if(index < g.length && g[index] <= s[i]){
                index++;
            }
        }
        return index;
    }
}
