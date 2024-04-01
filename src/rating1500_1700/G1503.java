package rating1500_1700;

public class G1503 {
    /*
    所有蚂蚁掉下来前的最后一刻
     */

    public int getLastMoment(int n, int[] left, int[] right) {
        int lastMoment = 0;
        for (int ant : left) {
            lastMoment = Math.max(lastMoment, ant);
        }
        for (int ant : right) {
            lastMoment = Math.max(lastMoment, n - ant);
        }
        return lastMoment;
    }
}
