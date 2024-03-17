package LCR;
import java.util.*;

public class LCR167 {
    /*
    招式拆解Ⅰ
     */

    public int dismantlingAction(String arr) {
        Map<Character, Integer> dic = new HashMap<>();
        int i = -1, res = 0, len = arr.length();
        for(int j = 0; j < len; j++) {
            if (dic.containsKey(arr.charAt(j)))
                i = Math.max(i, dic.get(arr.charAt(j))); // 更新左指针 i
            dic.put(arr.charAt(j), j); // 哈希表记录
            res = Math.max(res, j - i); // 更新结果
        }
        return res;
    }
}
