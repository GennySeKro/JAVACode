package HOT;

import org.junit.Test;

public class HOT647 {
    /*
    回文子串
     */

    /*
    暴力遍历
    时间复杂度O(N*N)
    空间复杂度O(N)
     */
    class one{
        public int countSubstrings(String s) {
            char[] res = s.toCharArray();
            int num = 0;
            for(int i = 0;i < s.length();i++){
                for(int j = i;j < s.length();j++){
                    if(right(res,i,j)){
                        num++;
                    }
                }
            }
            return num;
        }

        private boolean right(char[] res, int i, int j) {
            while(i != j){
                if(res[i] != res[j]){
                    return false;
                }
                if(i + 1 == j){
                    return true;
                }
                i++;
                j--;
            }
            return true;
        }
    }

    /*
    动态规划
    时间复杂度O(N*N)
    空间复杂度O(N*N)
     */
    class two{
        public int countSubstrings(String s) {
            boolean[][] dp = new boolean[s.length()][s.length()];
            char[] res = s.toCharArray();
            int num = 0;
            for(int i = 0;i < s.length();i++){
                dp[i][i] = true;
                num++;
            }
            for(int j = 1;j < s.length();j++){
                for(int i = 0;i < j;i++){
                    if(i + 1 == j){
                        dp[i][j] = (res[i] == res[j]);
                        if(dp[i][j]){
                            num++;
                        }
                    }else {
                        dp[i][j] = dp[i + 1][j - 1] && (res[i] == res[j]);
                        if(dp[i][j]){
                            num++;
                        }
                    }
                }
            }
            return num;
        }
    }

    @Test
    public void test(){
        String s = "aaaaa";
        System.out.println(new two().countSubstrings(s));
    }
}
