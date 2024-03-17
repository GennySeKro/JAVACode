package LCR;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LCR180 {
    /*
    文件组合
     */

    public int[][] fileCombination(int target) {
        int max = 0;
        if (target % 2 == 0){
            max = target / 2;
        }else {
            max = target / 2 + 1;
        }
        List<int[]> list = new ArrayList<>();
        int left = 1,right = 2;
        int sum = left + right;
        while (right <= max){
            if (sum == target){
                int[] temp = new int[right - left + 1];
                for (int i = left,j = 0;i <= right;i++,j++){
                    temp[j] = i;
                }
                list.add(temp);
                right = right + 1;
                sum = sum + right;
            } else if (sum < target) {
                right = right + 1;
                sum = sum + right;
            }else {
                sum = sum - left;
                left = left + 1;
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    @Test
    public void test(){
        System.out.println(Arrays.deepToString(fileCombination(18)));
    }
}
