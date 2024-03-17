package LCR;
import org.junit.Test;

import java.util.*;

public class LCR085 {
    /*
    括号生成
     */

    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs("",n,n);
        return res;
    }

    private void dfs(String s, int left, int right) {
        if(left < 0 || left > right){
            return;
        }
        if(left == 0 && right == 0){
            res.add(s);
            return;
        }
        dfs(s+'(',left-1,right);
        dfs(s+')',left,right-1);
    }

    @Test
    public void test(){
        System.out.println(generateParenthesis(3));
    }
}
