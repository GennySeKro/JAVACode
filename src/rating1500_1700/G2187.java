package rating1500_1700;

import org.junit.Test;

import java.util.Arrays;

public class G2187 {

    /*
    完成旅途的最少时间
     */

    public long minimumTime(int[] time, int totalTrips) {
        Arrays.sort(time);
        long left = 0;
        long right = (long) time[0] * totalTrips;
        while (left < right){
            long mid = (left + right) / 2;
            long trips = 0;
            for (int t : time){
                if (mid < t){
                    break;
                }
                trips = trips + mid / t;
            }
            if (trips >= totalTrips){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    @Test
    public void test(){
        System.out.println(minimumTime(new int[]{2}, 1));
    }
}
