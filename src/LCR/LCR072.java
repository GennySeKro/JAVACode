package LCR;

public class LCR072 {
    /*
    x的平方根
     */

    public int mySqrt(int x) {
       int l = 0, r = x, ans = -1;
       while (l <= r){
           int mid = l + (r - l) / 2;
           if ((long)mid * mid <= x){
               ans = mid;
               l = mid + 1;
           }else {
               r = mid - 1;
           }
       }
       return ans;
    }
}
