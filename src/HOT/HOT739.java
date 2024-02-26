package HOT;

public class HOT739 {
    /*
    每日温度
     */

    /*
    暴力遍历
    时间复杂度O(N*N)
    空间复杂度O(N)
     */
    class one{
        public int[] dailyTemperatures(int[] temperatures) {
            int[] res = new int[temperatures.length];
            for(int i = 0; i < temperatures.length;i++){
                boolean flag = true;
                for(int j = i; j < temperatures.length;j++){
                    if(temperatures[j] > temperatures[i]){
                        res[i] = j-i;
                        flag = false;
                        break;
                    }
                }
                if(flag == true){
                    res[i] = 0;
                }
            }
            return res;
        }
    }

    class two{
        public int[] dailyTemperatures(int[] temperatures) {
             int n = temperatures.length;
             int[] dp = new int[n];
             dp[n-1] = 0;
             for(int i = n-2; i >= 0; i--){
                 int j = i + 1;
                 while(j < n){
                     if(temperatures[j] > temperatures[i]){
                         dp[i] = j - i;
                         break;
                     }else {
                         if(dp[j] == 0){
                             dp[i] = 0;
                             break;
                         }
                         j = j + dp[j];
                     }
                 }
             }
             return dp;
        }
    }

}
