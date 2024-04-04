package Leetcode.week.week392;

import org.junit.Test;

public class HOT100242 {
    /*
    满足距离约束且字典序最小的字符串
     */

    public String getSmallestString(String s, int k) {
        if (k == 0){
            return s;
        }

        int index = 0;
        StringBuilder stringBuilder = new StringBuilder();

        while (index < s.length() && k > 0){
            if (s.charAt(index) == 'a'){
                stringBuilder.append('a');
                index++;
                continue;
            }
            if (s.charAt(index) + k == 'z'){
                if (s.charAt(index) - k >= 'a'){
                    stringBuilder.append((char)(s.charAt(index) - k));
                    index++;
                    break;
                }else {
                    stringBuilder.append('a');
                    k = k - s.charAt(index) + 'a';
                    index++;
                    continue;
                }
            }
            if (s.charAt(index) + k > 'z' && s.charAt(index) - k > 'a') {
                stringBuilder.append('a');
                k = s.charAt(index) + k - 'z' - 1;
                index++;
                continue;
            }
            if (s.charAt(index) + k > 'z' && s.charAt(index) - k < 'a'){
                if ('z' + 1 - s.charAt(index) >= s.charAt(index) - 'a'){
                    stringBuilder.append('a');
                    k = k - s.charAt(index) + 'a';
                    index++;
                    continue;
                }else {
                    stringBuilder.append('a');
                    k = k + s.charAt(index) - 'z' - 1;
                    index++;
                    continue;
                }
            }
            if (s.charAt(index) - k == 'a') {
               if ('z' + 1 - s.charAt(index) >= k){
                   stringBuilder.append('a');
                   index++;
                   break;
               }else {
                   stringBuilder.append('a');
                   k = k + s.charAt(index) - 'z' - 1;
                   index++;
                   continue;
               }
            }
            if (s.charAt(index) - k < 'a' && s.charAt(index) + k <= 'z'){
                stringBuilder.append('a');
                k = k - s.charAt(index) + 'a';
                index++;
                continue;
            }
            if (s.charAt(index) - k < 'a' && s.charAt(index) + k > 'z') {
                if (s.charAt(index) - 'a' <= 'z' + 1 - s.charAt(index)){
                    stringBuilder.append('a');
                    k = k + 'a' - s.charAt(index);
                    index++;
                    continue;
                }else {
                    stringBuilder.append('a');
                    k = k + s.charAt(index) - 1 - 'z';
                    index++;
                    continue;
                }
            }
            stringBuilder.append((char) (s.charAt(index) - k));
            index++;
            break;
        }
        for (int i = index;i < s.length();i++){
            stringBuilder.append(s.charAt(i));
        }
        return stringBuilder.toString();
    }

    @Test
    public void test(){
        System.out.println(getSmallestString("opmimhd", 14));
    }
}
