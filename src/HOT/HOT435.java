package HOT;

import org.junit.Test;

import java.util.Arrays;

public class HOT435 {
    /*
    无重叠区间
     */

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int count = 1;
        for(int i = 1;i < intervals.length;i++){
            if (intervals[i-1][1] <= intervals[i][0]){
                count++;
            }else {
                intervals[i][1] = Math.min(intervals[i-1][1],intervals[i][1]);
            }
        }
        return intervals.length - count;
    }

    @Test
    public void test(){
        System.out.println(eraseOverlapIntervals(new int[][]{{1,2},{2,3},{3,4},{1,3}}));
    }
}
