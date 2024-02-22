import java.util.ArrayList;
import java.util.List;

public class HOT621 {
    /*
    任务调度器
     */

    public int leastInterval(char[] tasks, int n) {
       int[] cnts = new int[26];
       for(char c : tasks){
           cnts[c - 'A']++;
       }
       int max = 0, tot = 0;
       for(int i = 0; i < 26; i++){
           max = Math.max(max,cnts[i]);
       }
       for(int i = 0; i < 26;i++){
           tot += max == cnts[i] ? 1 : 0;
       }
       return Math.max(tasks.length, (n+1)*(max-1)+tot);
    }
}
