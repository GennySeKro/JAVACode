package LCR;

import java.util.ArrayList;
import java.util.List;

public class LCR139 {
    /*
    训练计划Ⅰ
     */

    public int[] trainingPlan(int[] actions) {
        List<Integer> right = new ArrayList<>();
        List<Integer> left = new ArrayList<>();
        for (int i = 0;i < actions.length;i++){
            if (actions[i] % 2 == 0){
                right.add(actions[i]);
            }else {
                left.add(actions[i]);
            }
        }
        int[] res = new int[left.size() + right.size()];
        for (int i = 0;i < left.size();i++){
            res[i] = left.get(i);
        }
        for (int i = 0;i < right.size();i++){
            res[left.size() + i] = right.get(i);
        }
        return res;
    }
}
