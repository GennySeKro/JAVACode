import org.junit.Test;

public class HOT1143 {
    /*
    最长公共子序列
     */

    /*
    二维数组
     */
    class one{
        public int longestCommonSubsequence(String text1, String text2) {
            int[][] dp = new int[text1.length()][text2.length()];
            int max = 0;

            int k = 0;
            for(int i = 0;i < text1.length();i++){
                if(k == 0){
                    if(text1.charAt(i) == text2.charAt(0)){
                        dp[i][0] = 1;
                        k = 1;
                    }
                }else {
                    dp[i][0] = 1;
                }
                max = Math.max(max,dp[i][0]);
            }
            k = 0;
            for(int i = 0;i < text2.length();i++){
                if(k == 0){
                    if(text1.charAt(0) == text2.charAt(i)){
                        dp[0][i] = 1;
                        k = 1;
                    }
                }else {
                    dp[0][i] = 1;
                }
                max = Math.max(max,dp[0][i]);
            }

            for(int i = 1;i < text1.length();i++){
                for(int j = 1;j < text2.length();j++){
                    if(text1.charAt(i) == text2.charAt(j)){
                        dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1])) + 1;
                    }else {
                        dp[i][j] = Math.max(dp[i-1][j],Math.max(dp[i][j-1],dp[i-1][j-1]));
                    }
                    max = Math.max(max,dp[i][j]);
                }
            }

            return max;
        }
    }

    /*
    一维数组
     */
    class two{
        public int longestCommonSubsequence(String text1, String text2) {
            int n1 = text1.length();
            int n2 = text2.length();

            // 多从二维dp数组过程分析
            // 关键在于  如果记录  dp[i - 1][j - 1]
            // 因为 dp[i - 1][j - 1]  <!=>  dp[j - 1]  <=>  dp[i][j - 1]
            int [] dp = new int[n2 + 1];

            for(int i = 1; i <= n1; i++){

                // 这里pre相当于 dp[i - 1][j - 1]
                int pre = dp[0];
                for(int j = 1; j <= n2; j++){

                    //用于给pre赋值
                    int cur = dp[j];
                    if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                        //这里pre相当于dp[i - 1][j - 1]   千万不能用dp[j - 1] !!
                        dp[j] = pre + 1;
                    } else{
                        // dp[j]     相当于   dp[i - 1][j]
                        // dp[j - 1] 相当于   dp[i][j - 1]
                        dp[j] = Math.max(dp[j], dp[j - 1]);
                    }

                    //更新dp[i - 1][j - 1], 为下次使用做准备
                    pre = cur;
                }
            }

            return dp[n2];
        }
    }


    @Test
    public void test(){
        System.out.println(new two().longestCommonSubsequence("abcba", "abcbcba"));
    }
}
