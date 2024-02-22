import org.junit.Test;

import java.util.Arrays;

public class HOT474 {
    /*
    一和零
     */

    /*
    递归:超时
     */
    class one{
        int max = 0;
        int[][] num;
        public int findMaxForm(String[] strs, int m, int n) {
            num = new int[strs.length][2];
            for(int i = 0;i < strs.length;i++){
                for(int j = 0;j < strs[i].length();j++){
                    if(strs[i].charAt(j) == '0'){
                        num[i][0] = num[i][0] + 1;
                    }else {
                        num[i][1] = num[i][1] + 1;
                    }
                }
            }
            dfs(strs,m,n,0,0);
            return max;
        }

        private void dfs(String[] strs, int m, int n, int index, int len) {
            if(m < 0 || n < 0){
                return;
            }
            if(m >= 0 && n >= 0){
                max = Math.max(max, len);
            }
            for(int i = index;i < strs.length;i++){
                int num0 = num[i][0];
                int num1 = num[i][1];
                dfs(strs,m-num0,n-num1,i+1,len+1);
            }
        }
    }

    /*
    动态规划
     */
    class two{
        public int findMaxForm(String[] strs, int m, int n) {
            //dp[i][j]表示i个0和j个1时的最大子集
            int[][] dp = new int[m + 1][n + 1];
            int oneNum, zeroNum;
            for (String str : strs) {
                oneNum = 0;
                zeroNum = 0;
                for (char ch : str.toCharArray()) {
                    if (ch == '0') {
                        zeroNum++;
                    } else {
                        oneNum++;
                    }
                }
                //倒序遍历
                for (int i = m; i >= zeroNum; i--) {
                    for (int j = n; j >= oneNum; j--) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                    }
                }
            }
            return dp[m][n];
        }
    }

    @Test
    public void test(){
        System.out.println(new two().findMaxForm(new String[]{"10","0001","111001","1","0"},5,3));
    }
}
