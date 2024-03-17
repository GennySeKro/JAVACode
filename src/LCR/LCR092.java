package LCR;

public class LCR092 {
    /*
    将字符串翻转到单调递增
     */

    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[] zero = new int[n];
        int[] one = new int[n];
        zero[0] = s.charAt(0) == '0' ? 0 : 1;
        one[0] =s.charAt(0) == '0' ? 1 : 0;
        for(int i = 1; i < n; ++i){
            if(s.charAt(i) == '0'){
                zero[i] = zero[i-1];
                one[i] = Math.min(one[i-1], zero[i-1]) + 1;
            }else if(s.charAt(i) == '1'){
                zero[i] = zero[i-1] + 1;
                one[i] = Math.min(one[i-1], zero[i-1]);
            }
        }
        return Math.min(one[n-1], zero[n-1]);
    }
}
