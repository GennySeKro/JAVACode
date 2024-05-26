package Leetcode.week.week400;

import org.junit.Test;

import java.util.*;

public class HOT100322 {
    /*
    删除星号以后字典序最小的字符串
     */

    public String clearStars(String s) {
        if (!s.contains("*")){
            return s;
        }
        Set<Integer> del = new HashSet<>();
        TreeMap<Character, LinkedList<Integer>> map = new TreeMap<>();
        for (int i = 0;i < s.length();i++){
            char tempChar = s.charAt(i);
            if (tempChar != '*'){
                LinkedList<Integer> tempList = map.getOrDefault(tempChar, new LinkedList<>());
                tempList.add(i);
                map.put(tempChar, tempList);
            }else {
                char leftChar = map.firstKey();
                LinkedList<Integer> tempList = map.get(leftChar);
                int index = tempList.getLast();
                tempList.removeLast();
                if (tempList.isEmpty()){
                    map.remove(leftChar);
                }
                del.add(index);
                del.add(i);
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0;i < s.length();i++){
            if (!del.contains(i)){
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }

    @Test
    public void test(){
        System.out.println(clearStars("abca*b*"));
    }


}
