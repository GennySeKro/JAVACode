import org.junit.Test;

public class HOT5 {

    /*
    最长回文子串
     */
    public String longestPalindrome(String s){
        if (s.length() == 1){
            return s;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0;i < s.length();i++){
            if (i == 0){
                dp[i][i] = true;
            }else {
                dp[i][i] = true;
                dp[i][i-1]= true;
            }

        }
        int len = 1, left = 0, right = s.length() - 1;
        for (int i = 1;i < s.length();i++){
            for (int j = 0;j < i;j++){
                dp[j][i] = (dp[j+1][i-1] && s.charAt(i) == s.charAt(j)) ? true : false;
                if (dp[j][i] == true){
                    if (len < i - j + 1){
                        len = i - j + 1;
                        left = j;
                        right = i;
                    }
                }
            }
        }
        if (len == 1){
            return s.substring(0,1);
        }else {
            return s.substring(left,right + 1);
        }

    }

    @Test
    public void test(){
        System.out.println(longestPalindrome("aaaa"));
    }
}
