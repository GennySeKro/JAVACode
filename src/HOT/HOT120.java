package HOT;

import org.junit.Test;

import java.util.*;

public class HOT120 {
    /*
    三角形最小路径和
     */

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1){
            return triangle.get(0).get(0);
        }
        List<List<Integer>> res = new ArrayList<>();
        int max = Integer.MAX_VALUE;
        for (int i = 0;i < triangle.size();i++){
            for (int j = 0;j < triangle.get(i).size();j++){
                if (i == 0){
                    res.add(new ArrayList<>());
                    res.get(i).add(triangle.get(i).get(j));
                }else {
                    if (j == 0){
                        res.add(new ArrayList<>());
                        res.get(i).add(triangle.get(i).get(0) + res.get(i - 1).get(0));
                    }else {
                        if (j == triangle.get(i).size() - 1){
                            res.get(i).add(triangle.get(i).get(j) + res.get(i - 1).get(j - 1));
                        }else {
                            res.get(i).add(triangle.get(i).get(j) + Math.min(res.get(i - 1).get(j - 1), res.get(i - 1).get(j)));
                        }

                    }
                    if (i == triangle.size() - 1){
                        max = Math.min(max, res.get(i).get(j));
                    }
                }
            }
        }
        return max;
    }

    @Test
    public void test(){
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(minimumTotal(triangle));
    }
}
