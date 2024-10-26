package Leetcode.week.week396;

public class HOT100284 {
    /*
    有效单词
     */

    public boolean isValid(String word) {
        if (word.length() < 3){
            return false;
        }

        int[] wordNum = new int[2];
        for (int i = 0;i < word.length();i++){
            char temp = word.charAt(i);
            if (temp >= 'a' && temp <= 'z' || temp >= 'A' && temp <= 'Z'){
                if (temp == 'a' || temp == 'e' || temp == 'i' || temp == 'o' || temp == 'u' ||
                        temp == 'A' || temp == 'E' || temp == 'I' || temp == 'O' || temp == 'U'){
                    wordNum[0] = 1;
                }else {
                    wordNum[1] = 1;
                }
            } else if (temp >= '0' && temp <= '9') {
                continue;
            }else {
                return false;
            }
        }
        if (!(wordNum[0] == 1 && wordNum[1] == 1)){
            return false;
        }else {
            return true;
        }
    }
}
