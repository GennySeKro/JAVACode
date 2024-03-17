package LCR;

import java.util.*;

public class LCR186 {
    /*
    文物朝代判断
     */

    public boolean checkDynasty(int[] places) {
        Set<Integer> set = new HashSet<>();
        int max = 0, min = 14;
        for (int place : places){
            if (place == 0){
                continue;
            }
            max = Math.max(max, place);
            min = Math.min(min, place);
            if (set.contains(place)){
                return false;
            }
            set.add(place);
        }
        return max - min < 5;
    }
}
