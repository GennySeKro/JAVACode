package LCR;

import java.util.*;

import static java.util.Collections.*;

public class LCR074 {
    /*
    合并区间
     */

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);

        List<int[]> ans = new ArrayList<int[]>();
        ans.add(intervals[0]);
        for(int i = 1;i < intervals.length; i++){
            int s = intervals[i][0], e = intervals[i][1];
            if(ans.get(ans.size() - 1)[1] < s){
                ans.add(intervals[i]);
            }else {
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1],e);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
