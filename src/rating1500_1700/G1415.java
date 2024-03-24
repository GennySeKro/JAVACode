package rating1500_1700;

<<<<<<< HEAD
public class G1415 {
    /*
    长度为n的开心字符串种字典序第k小的字符串
     */

    public String getHappyString(int n, int k) {

    }

=======
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class G1415 {
    /*
    长度为n的开心字符串中字典序第k小的字符串
     */

    StringBuilder res = new StringBuilder();
    char[] str = new char[]{'a', 'b', 'c'};
    public String getHappyString(int n, int k) {
        dfs(n, ' ', k);
        return res.toString();
    }

    private void dfs(int i, char prev, double k) {
        if (i <= 0 || k <= 0){
            return;
        }

        double n = Math.pow(2, i - 1);

        for (int j = 0;j < 3;j++){
            if (str[j] == prev){
                continue;
            }
            if (n >= k){
                res.append(str[j]);
                dfs(i - 1, str[j], k);
                return;
            }
            k = k - n;
        }
    }


    @Test
    public void test(){
        System.out.println(getHappyString(3,9));
    }
>>>>>>> origin/master
}
