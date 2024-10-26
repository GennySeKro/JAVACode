package Binary;

public class B1870 {
    /*
    准时到达的列车最小时速
     */

    public int minSpeedOnTime(int[] dist, double hour) {
        if (dist.length > Math.ceil(hour)){
            return -1;
        }

        int left = 1, right = (int)1e9;
        while (left <= right){
            int mid = (left + right) >>> 1;
            if (check(mid, dist, hour)){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean check(int mid, int[] dist, double hour){
        double time = 0.0;
        for (int num : dist){
            time = Math.ceil(time);
            time += (double) num / mid;
        }

        return time <= hour;
    }
}
