package rating1500_1700;

import org.junit.Test;

public class G2522 {
    /*
    将字符串分割成值不超过k的子字符串
     */

    public int minimumPartition(String s, int k) {
        int res = 0;
        int left = 0, right = 0;
        long sum = 0;
        while (right != s.length()){
            if (left == right){
                int num = s.charAt(left) - '0';
                if (num > k){
                    return -1;
                }else {
                    sum = sum + num;
                    right++;
                }
            }else {
                if (sum * 10 + s.charAt(right) - '0' > k){
                    sum = 0;
                    res++;
                    left = right;
                }else {
                    sum = sum * 10 + s.charAt(right) - '0';
                    right++;
                }
            }
        }
        return res + 1;
    }

    @Test
    public void test(){
        System.out.println(minimumPartition("238182", 5));
    }
}
