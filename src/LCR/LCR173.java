package LCR;

public class LCR173 {
    /*
    点名
     */

    public int takeAttendance(int[] records) {
        int left = 0, right = records.length - 1;
        while (left < right){
            int mid = left + right + 1 >> 1;
            if (records[mid] == mid){
                left = mid;
            }else {
                right = mid - 1;
            }
        }
        return records[right] != right ? right : right + 1;
    }
}
