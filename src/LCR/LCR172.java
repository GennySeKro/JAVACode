package LCR;

public class LCR172 {
    /*
    统计目标成绩的出现次数
     */

    public int countTarget(int[] scores, int target) {
        int res = 0;
        for (int score : scores){
            if (score == target){
                res++;
            } else if (score > target) {
                break;
            }
        }
        return res;
    }
}
