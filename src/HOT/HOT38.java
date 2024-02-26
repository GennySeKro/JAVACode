package HOT;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class HOT38 {

    /*
    外观数列
     */

    public String countAndSay(int n) {
        if (n == 1){
            return "1";
        }
        List<String> res = new ArrayList<>();
        res.add("1");
        for (int i = 1;i < n;i++){
            int[] num = new int[9];
            StringBuilder str = new StringBuilder();
            int k = 1;
            for (int j = 1;j < res.get(i-1).length();j++){
                if (res.get(i-1).charAt(j) == res.get(i-1).charAt(j-1)){
                    k++;
                }else {
                    str.append(k);
                    str.append(res.get(i-1).charAt(j-1));
                    k = 1;
                }
            }
            str.append(k);
            str.append(res.get(i-1).charAt(res.get(i-1).length()-1));
            res.add(str.toString());
        }
        return res.get(n - 1);
    }

    @Test
    public void test(){
        System.out.println(countAndSay(5));
    }
}
