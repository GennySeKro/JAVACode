package LCR;

import org.junit.Test;

import java.util.Objects;

public class LCR181 {
    /*
    字符串中的单词反转
     */

    public String reverseMessage(String message) {
        String[] str = message.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = str.length - 1;i >= 0;i--){
            if (!Objects.equals(str[i], "")){
                stringBuilder.append(str[i]).append(" ");
            }
        }
        String res = stringBuilder.toString();
        if (res.equals("")){
            return "";
        }
        return res.substring(0, res.length() - 1);
    }

    @Test
    public void test(){
        System.out.println(reverseMessage("   "));
    }
}
