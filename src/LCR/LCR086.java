package LCR;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LCR086 {
    /*
    分割回文字符串
     */

    List<List<String>> res = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();
    public String[][] partition(String s) {
         boolean[][] dp = new boolean[s.length()][s.length()];
         for (int i = 0;i < s.length();i++){
             for (int j = i;j >= 0;j--){
                 if (j == i){
                     dp[j][i] = true;
                 } else if (j == i - 1) {
                     dp[j][i] = s.charAt(j) == s.charAt(i);
                 }else {
                     dp[j][i] = dp[j + 1][i - 1] && s.charAt(j) == s.charAt(i);
                 }
             }
         }

         backTrack(dp, 0, s);

         String[][] str = new String[res.size()][];
         for (int i = 0;i < res.size();i++){
             String[] temp = new String[res.get(i).size()];
             for (int j = 0;j < res.get(i).size();j++){
                 temp[j] = res.get(i).get(j);
             }
             str[i] = temp;
         }
         return str;
    }

    private void backTrack(boolean[][] dp, int index, String s) {
        if (index == s.length()){
            res.add(new ArrayList<>(path));
        }
        for (int i = index;i < s.length();i++){
            if (dp[index][i]){
                path.add(s.substring(index, i + 1));
                backTrack(dp, i + 1, s);
                path.removeLast();
            }
        }
    }

    @Test
    public void test(){
        System.out.println(Arrays.deepToString(partition("google")));
    }
}
