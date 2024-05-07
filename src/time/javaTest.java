package time;

import org.junit.Test;

import java.util.*;


public class javaTest {

    @Test
    public void test(){
       LargestNum(new int[]{10,9,8,5,4,1,2,3});
    }


    public String LargestNum(int[] nums) {
        String[] res = new String[nums.length];
        for(int i = 0;i < nums.length;i++){
            res[i] = "" + nums[i];
        }
        Arrays.sort(res, (a, b)->{
                String temp0 = a + b, temp1 = b + a;
        return temp1.compareTo(temp0);
        });

        StringBuilder ans = new StringBuilder();
        for (int i = 0;i < nums.length;i++){
            ans.append(res[i]);
        }
        int len = ans.length();
        int k = 0;
        while(k < len - 1 && ans.charAt(k)== '0'){
            k++;
        }
        return ans.substring(k);
    }
}
