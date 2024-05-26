package Leetcode.week.week399;

import org.junit.Test;

public class HOT100326 {
    /*
    压缩字符串Ⅲ
     */

    public String compressedString(String word) {
        int tempLen = 1;
        word = word + "1";
        StringBuilder res = new StringBuilder();
        for (int i = 0;i < word.length() - 1;i++){
            if (word.charAt(i) == word.charAt(i + 1)){
                if (tempLen == 9){
                    res.append("9");
                    res.append(word.charAt(i - 1));
                    tempLen = 1;
                }else {
                    tempLen++;
                }
            }else {
                res.append(tempLen);
                res.append(word.charAt(i));
                tempLen = 1;
            }
        }

        return res.toString();
    }

    @Test
    public void test(){
        System.out.println(compressedString("aaaaaaaaaaaaaabb"));
    }
}
