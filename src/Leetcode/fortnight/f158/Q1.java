package Leetcode.fortnight.f158;

import org.junit.Test;

import java.util.*;

public class Q1 {
    /*
    选择不同x值三元组使y值之和最大
     */

    public int maxSumDistinctTriplet(int[] x, int[] y) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        //保存所有不相同的下标
        for (int i = 0; i < x.length; i++){
            ArrayList<Integer> list;
            if (map.containsKey(x[i])){
                list = map.get(x[i]);
            }else {
                list = new ArrayList<>();
            }
            list.add(y[i]);
            map.put(x[i], list);
        }

        ArrayList<Integer> max = new ArrayList<>();

        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()){
            max.add(Collections.max(entry.getValue()));
        }

        if (max.size() < 3){
            return -1;
        }

        Collections.sort(max);
        Collections.reverse(max);
        return max.get(0) + max.get(1) + max.get(2);
    }

    @Test
    public void test(){
        System.out.println(maxSumDistinctTriplet(new int[]{19,15,7,13}, new int[]{13,11,13,11}));
    }
}
