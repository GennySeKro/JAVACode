package Binary;

import org.junit.Test;

import java.util.Arrays;

public class B2187 {
    /*
    完成旅途的最小时间
     */

    public long minimumTime(int[] time, int totalTrips) {
        Arrays.sort(time);
        long left = 1;
        long right = (long)time[0] * totalTrips;

        while (left <= right){
            long mid = (left + right) >>> 1;
            long tempValue = 0L;
            for (int i = 0;i < time.length;i++){
                tempValue += mid / time[i];
            }
            if (tempValue >= totalTrips){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }

        return left;
    }

    @Test
    public void test(){
        System.out.println(minimumTime(new int[]{10000}, 10000000));
    }
}
