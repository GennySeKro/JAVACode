package rating1500_1700;

import org.junit.Test;

import java.util.Arrays;

public class G1657 {
    /*
    确定两个字符串是否接近
     */

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()){
            return false;
        }
        int[] word1Num = new int[26];
        int[] word2Num = new int[26];
        for (int i = 0;i < word1.length();i++){
            word1Num[word1.charAt(i) - 'a']++;
            word2Num[word2.charAt(i) - 'a']++;
        }
        for (int i = 0;i < 26;i++){
            if (word1Num[i] == 0 && word2Num[i] != 0 || word1Num[i] != 0 && word2Num[i] == 0){
                return false;
            }
        }
        Arrays.sort(word1Num);
        Arrays.sort(word2Num);
        for (int i = 0;i < 26;i++){
            if (word1Num[i] != word2Num[i]){
                return false;
            }
        }
        return true;
    }

    @Test
    public void test(){
        System.out.println(closeStrings("uau", "ssx"));
    }
}
