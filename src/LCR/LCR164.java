package LCR;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LCR164 {
    /*
    破解闯关密码
     */

    public String crackPassword(int[] nums) {
        List<String> strList = new ArrayList<>();
        for (int num : nums) {
            strList.add(String.valueOf(num));
        }
        strList.sort((s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        StringBuilder sb = new StringBuilder();
        for (String str : strList) {
            sb.append(str);
        }
        return sb.toString();
    }

    @Test
    public void test(){
        System.out.println(crackPassword(new int[]{0, 3, 30, 34, 5, 9}));
    }
}
