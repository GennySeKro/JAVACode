package rating1500_1700;

public class G3029 {
    /*
    将单词恢复初始状态所需的最短时间
     */

    public int minimumTimeToInitialState(String word, int k) {
        int len = word.length();
        int res = 0;
        int sum = (int) Math.ceil((double) len / k);
        for (int i = k;i < len;i = i + k){
            res++;
            if (word.indexOf(word.substring(i)) == 0){
                return res;
            }
        }
        return sum;
    }
}
