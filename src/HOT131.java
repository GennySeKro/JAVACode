import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class HOT131 {
    /*
    分割回文串
     */

    List<List<String>> lists = new ArrayList<>();
    LinkedList<String> deque = new LinkedList<>();


    public List<List<String>> partition(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length();i++){
            dp[i][i] = true;
            if(i + 1 < s.length()  ){
                dp[i+1][i] = true;
            }
        }
        for(int i = 1;i < s.length();i++){
            for(int j = 0;j < i;j++){
                dp[j][i] = dp[j+1][i-1] && (s.charAt(j) == s.charAt(i));
            }
        }
        backTracking(s, 0,dp);
        return lists;
    }

    private void backTracking(String s, int index, boolean[][] dp) {
        if(index >= s.length()){
            lists.add(new ArrayList<>(deque));
            return;
        }
        for(int i = index;i < s.length();i++){
            if(dp[index][i]){
                String str = s.substring(index,i+1);
                deque.addLast(str);
            }else {
                continue;
            }
            backTracking(s,i+1,dp);
            deque.removeLast();
        }
    }

    @Test
    public void test(){
        System.out.println(partition("aab"));
    }
}
