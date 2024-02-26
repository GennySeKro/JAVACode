package HOT;

import org.junit.Test;

public class HOT392 {
    /*
    判断子序列
     */

    /*
    暴力遍历
    时间复杂度O(m*n)
    空间复杂度O(1)
     */
    class one{
        public boolean isSubsequence(String s, String t) {
            int k = 0;
            int flag = 0;
            for(int i = 0;i < s.length();i++){
                for(int j = k;j < t.length();j++){
                    if(s.charAt(i) == t.charAt(j)){
                        flag++;
                        k = j+1;
                        break;
                    }
                }
            }
            if(flag == s.length()){
                return true;
            }else {
                return false;
            }
        }
    }

    /*
    动态规划
    时间复杂度O(m*n)
    空间复杂度O(m*n)
     */
    class two{
        public boolean isSubsequence(String s, String t) {
            int[][] dp = new int[s.length()+1][t.length()+1];
            for(int i = 1;i < s.length()+1;i++){
                for(int j = 1;j < t.length();j++){
                    if(s.charAt(i-1) == t.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }else {
                        dp[i][j] = dp[i][j-1];
                    }
                }
            }
            if(dp[s.length()][t.length()] == s.length()){
                return true;
            }else{
                return false;
            }
        }
    }


    @Test
    public void test(){
        System.out.println(new two().isSubsequence("axc", "ahbgdc"));
    }
}
