package Leetcode.week.week400;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class HOT100311 {
    /*
    无需开会的工作日
     */

    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }else {
                    return o1[0] - o2[0];
                }
            }
        });

        int work = 0, right = meetings[0][1];
        if (meetings[0][0] != 1){
            work = work + meetings[0][0] - 1;
        }
        for (int i = 1;i < meetings.length;i++){
            if (meetings[i][0] <= right && meetings[i][1] >= right){
                right = meetings[i][1];
            } else if (meetings[i][0] >= right) {
                work = work + meetings[i][0] - right - 1;
                right = meetings[i][1];
            }
        }
        if (right < days){
            work = work + days - right;
        }
        return work;
    }

    @Test
    public void test(){
        System.out.println(countDays(57, new int[][]{{3,49},{23,44},{21,56},{26,55},{23,52},{2,9},{1,48},{3,31}}));
    }
}
