import java.util.Arrays;
import java.util.LinkedList;

public class HOT406 {
    /*
    根据身高重建队列
     */

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });

        LinkedList<int[]> que = new LinkedList<>();
        for(int[] p : people){
            que.add(p[1],p);
        }
        return que.toArray(new int[people.length][]);
    }
}
