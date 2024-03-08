package LCR;

import java.util.HashSet;
import java.util.Set;

public class LCR120 {
    /*
    寻找文件副本
     */

    public int findRepeatDocument(int[] documents) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0;i < documents.length;i++){
            if (!set.contains(documents[i])){
                set.add(documents[i]);
            }else {
                return documents[i];
            }
        }
        return -1;
    }
}
