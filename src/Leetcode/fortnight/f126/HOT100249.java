package Leetcode.fortnight.f126;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class HOT100249 {
    /*
    替换字符串中的问号使分数最小
     */

    public String minimizeStringValue(String s) {
        Map<Character,Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        ArrayList<Character> list = new ArrayList<>();
        for(char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(char c : s.toCharArray()){
            if(c == '?'){
                //找到最小出现次数的字典序最小字符
                int min = Integer.MAX_VALUE;
                char minChar = 'z';
                for(char i = 'z';i>='a';i--){
                    int v = map.getOrDefault(i,0);
                    if(v <= min){
                        min = v;
                        minChar = i;
                    }
                }
                list.add(minChar);
                map.put(minChar,map.getOrDefault(minChar,0)+1);
            }
        }
        Collections.sort(list);
        int idx = 0;
        for(char c : s.toCharArray()){
            if(c == '?'){
                sb.append(list.get(idx++));
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }

    @Test
    public void test(){
        System.out.println(minimizeStringValue("abcdefghijklmnopqrstuvwxy??"));
    }
}
