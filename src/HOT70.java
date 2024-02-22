import org.junit.Test;

public class HOT70 {
    /*
    爬楼梯
    空间复杂度O(n),时间复杂度O(n)
     */

    public int climbStairs(int n){
        if(n == 1){
            return 1;
        }
        int[] res = new int[n];
        res[0] = 1;
        res[1] = 2;
        for(int i = 2;i < n;i++){
            res[i] = res[i-1] + res[i-2];
        }
        return res[n-1];
    }

    /*
    优化：用有限个空间存储每次计算的结果
    空间复杂度O(1)
     */
    @Test
    public int climbStairs1(int n){
        if(n == 1){
            return 1;
        }
        int last = 2;
        int last_last = 1;
        int now = 2;
        for(int i = 2;i < n;i++){
            now = last + last_last;
            last_last = last;
            last = now;
        }
        return now;
    }
}
