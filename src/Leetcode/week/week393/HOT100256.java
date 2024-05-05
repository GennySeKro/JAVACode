package Leetcode.week.week393;

public class HOT100256 {
    /*
    替换字符可以得到的最晚时间
     */

    public String findLatestTime(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] str = s.toCharArray();
        for (int i = 0;i < str.length;i++){
            if (str[i] != '?'){
                stringBuilder.append(s.charAt(i));
            }else {
                if (i == 0){
                    if (str[1] == '0' || str[1] == '1' || str[1] == '?'){
                        stringBuilder.append('1');
                    }else {
                        stringBuilder.append('0');
                    }

                }else if (i == 1) {
                    if (str[0] == '0') {
                        stringBuilder.append('9');
                    } else {
                        stringBuilder.append('1');
                    }
                } else if (i == 3) {
                    stringBuilder.append('5');
                }else {
                    stringBuilder.append('9');
                }
            }
        }
        return stringBuilder.toString();
    }
}
