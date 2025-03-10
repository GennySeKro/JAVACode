package Leetcode.week.week440;

import org.junit.Test;

public class Q1 {
    /*
    将水果放入篮子
     */

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int res = fruits.length;

        for (int i = 0; i < fruits.length; i++){
            for (int j = 0;j < fruits.length; j++){
                if (baskets[j] != 0 && baskets[j] >= fruits[i]){
                    baskets[j] = 0;
                    res--;
                    break;
                }
            }
        }

        return res;
    }

    @Test
    public void test(){
        System.out.println(numOfUnplacedFruits(new int[]{1,2,1}, new int[]{3,2,2}));
    }
}
