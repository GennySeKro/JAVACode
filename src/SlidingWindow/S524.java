package SlidingWindow;
import java.util.*;

public class S524 {
    /*
    通过删除字母匹配到字典里最长单词
     */

    public String findLongestWord(String s, List<String> dictionary) {

        Collections.sort(dictionary, (a,b)->{
            if (a.length() != b.length()) return b.length() - a.length();
            return a.compareTo(b);
        });
        for (int i = 0;i < dictionary.size();i++){
            int sIndex = 0, dictionaryIndex = 0;
            while (sIndex < s.length() && dictionaryIndex < dictionary.get(i).length()){
                if (s.charAt(sIndex) == dictionary.get(i).charAt(dictionaryIndex)){
                    sIndex++;
                    dictionaryIndex++;
                }else {
                    sIndex++;
                }
            }
            if (dictionaryIndex == dictionary.get(i).length()){
                return dictionary.get(i);
            }
        }

        return "";
    }
}
