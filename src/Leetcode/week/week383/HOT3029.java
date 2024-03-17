package Leetcode.week.week383;

public class HOT3029 {
    /*
    将单词恢复初始状态所需的最短时间 I
     */

    public int minimumTimeToInitialState(String word, int k) {
        int len = word.length();
        int res = 0;  // 切割次数
        int sum = (int) Math.ceil((double) len / k); // 最大切割次数
        for (int i = k; i < len; i += k) {
            res++;
            if(word.indexOf(word.substring(i)) == 0) return res;
        }
        return sum;
    }
}
