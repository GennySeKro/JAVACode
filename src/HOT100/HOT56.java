package HOT100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class HOT56 {
    /*
    合并区间
     */

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1){
            return intervals;
        }
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        ArrayList<int[]> list = new ArrayList<>();

        int left = 0, right = 0;
        for (int i = 0;i < intervals.length;i++){
            if (i > 0){
                if (intervals[i][0] >= left && intervals[i][0] <= right){
                    right = Math.max(right, intervals[i][1]);
                }else {
                    list.add(new int[]{left, right});
                    left = intervals[i][0];
                    right = intervals[i][1];
                }
            }else {
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
        list.add(new int[]{left, right});

        int[][] res = new int[list.size()][2];
        for (int i = 0;i < res.length;i++){
            res[i] = list.get(i);
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(Arrays.deepToString(merge(new int[][]{{15, 18}, {1, 3}, {2, 6}, {8, 10}})));
    }
}
