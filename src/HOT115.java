import org.junit.Test;

public class HOT115 {
    /*
    不同的子序列
     */

    public int numDistinct(String s, String t) {
        if(s.length() < t.length()){
            return 0;
        }
        int[][] dp = new int[t.length()][s.length()];
        int k;
        if(t.charAt(0) == s.charAt(0)){
            dp[0][0] = 1;
        }
        for(int i = 1;i < s.length();i++){
            if(t.charAt(0) == s.charAt(i)){
                dp[0][i] = dp[0][i-1]+1;
            }else {
                dp[0][i] = dp[0][i-1];
            }
        }

        for(int i = 1;i < t.length();i++){
            k = 0;
            for(int j = i;j < s.length();j++){
                if(t.charAt(i) == s.charAt(j)){
                    if(k == 0){
                        dp[i][j] = dp[i-1][j-1];
                        k = 1;
                    }else {
                        dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                    }
                }else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[t.length()-1][s.length()-1];
    }

    @Test
    public void test(){
        System.out.println(numDistinct("aabb", "ab"));
    }
}
