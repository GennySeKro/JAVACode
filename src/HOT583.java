import org.junit.Test;

public class HOT583 {
    /*
    两个字符串的删除操作
     */

    /*
    动态规划二维数组
     */
    class one{
        public int minDistance(String word1, String word2) {
            int[][] dp = new int[word1.length()][word2.length()];

            int k = 0;
            for(int i = 0;i < word2.length();i++){
                if(word1.charAt(0) == word2.charAt(i)){
                    dp[0][i] = 1;
                    k = 1;
                }else {
                    if(k == 0){
                        dp[0][i] = 0;
                    }else {
                        dp[0][i] = 1;
                    }
                }
            }

            k = 0;
            for(int i = 0;i < word1.length();i++){
                if(word1.charAt(i) == word2.charAt(0)){
                    dp[i][0] = 1;
                    k = 1;
                }else {
                    if(k == 0){
                        dp[i][0] = 0;
                    }else {
                        dp[i][0] = 1;
                    }
                }
            }

            for(int i = 1;i < word1.length();i++){
                for(int j = 1;j < word2.length();j++){
                    if(word1.charAt(i) == word2.charAt(j)){
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }else {
                        dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                    }
                }
            }

            if(dp[word1.length()-1][word2.length()-1] == Math.min(word1.length(),word2.length())){
                return Math.max(word1.length(),word2.length()) - dp[word1.length()-1][word2.length()-1];
            }else {
                return word1.length() + word2.length() + 2 * -dp[word1.length()-1][word2.length()-1];
            }
        }
    }

    /*
    动态规划一维数组
     */
    class two{
        public int minDistance(String word1, String word2) {
            int[] dp = new int[word2.length()+1];

            for(int i = 1;i <= word1.length();i++){
                int pre = dp[0];
                for(int j = 1;j <= word2.length();j++){
                    int cur = dp[j];
                    if(word1.charAt(i-1) == word2.charAt(j-1)){
                        dp[j] = pre + 1;
                    }else {
                        dp[j] = Math.max(dp[j], dp[j-1]);
                    }
                    pre = cur;
                }
            }

            if(dp[word2.length()] == Math.min(word1.length(),word2.length())){
                return Math.max(word1.length(),word2.length()) - dp[word2.length()];
            }else {
                return word1.length() + word2.length() - 2 * dp[word2.length()];
            }
        }
    }



    @Test
    public void test(){
        System.out.println(new two().minDistance("leetcode", "etco"));
    }
}
