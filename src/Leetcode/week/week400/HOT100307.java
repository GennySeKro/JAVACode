package Leetcode.week.week400;

public class HOT100307 {
    /*
    候诊室中的最少椅子数
     */

    public int minimumChairs(String s) {
        int res = 0, temp = 0;
        for (int i = 0;i < s.length();i++){
            if (s.charAt(i) == 'E'){
                temp++;
                res = Math.max(res, temp);
            } else {
                if (temp > 0){
                    temp--;
                }
            }
        }
        return res;
    }
}
