import java.util.IllegalFormatCodePointException;

public class HOT58 {
    /*
    最后一个单词的长度
     */

    public int lengthOfLastWord(String s) {
        int res = 0, flag = 0;
        for (int i = s.length() - 1;i >= 0;i--){
            if (s.charAt(i) == ' ' && flag == 1){
                return res - 1;
            }
            if (s.charAt(i) != ' ' && flag == 0){
                flag = 1;
                res++;
            }
            if (s.charAt(i) != ' ' && flag == 1){
                res++;
            }
        }
        return res - 1;
    }
}
