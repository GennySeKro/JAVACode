package LCR;

import org.junit.Test;

public class LCR165 {
    /*
    解密数字
     */

    public int crackNumber(int ciphertext) {
        String str = String.valueOf(ciphertext);
        if (str.length() == 1){
            return 1;
        }
        int[] dp = new int[str.length()];
        dp[0] = 1;

        if (Integer.parseInt(str.substring(0,2)) <= 25 && Integer.parseInt(str.substring(0,2)) >= 0){
            dp[1] = 2;
        }else {
            dp[1] = 1;
        }
        for (int i = 2;i < str.length();i++){
           if (str.charAt(i - 1) == '1' || str.charAt(i - 1) == '2' && str.charAt(i) <= '5'){
               dp[i] = dp[i - 1] + dp[i - 2];
           }else {
               dp[i] = dp[i - 1];
           }
        }
        return dp[str.length() - 1];
    }

    @Test
    public void test(){
        System.out.println(crackNumber(506));
    }
}
