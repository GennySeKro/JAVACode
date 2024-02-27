package LCR;
import org.junit.Test;

import java.util.*;

public class LCR063 {
    /*
    单词替换
     */

    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String word : dictionary){
            trie.insert(word);
        }
        StringBuilder res = new StringBuilder();
        String[] array = sentence.split(" ");
        for (String word : array){
            if (trie.match(word) == 0){
                res.append(word);
                res.append(" ");
            }else {
                res.append(word.substring(0,trie.match(word)));
                res.append(" ");
            }
        }
        return res.toString().substring(0,res.length());
    }

    class Trie {
        Map<Character, Trie> children;
        char value;
        int val;
        public Trie() {
            children = new HashMap<Character, Trie>();
            val = 0;
        }
        public void insert(String word){
            Trie node = this;
            for (int i = 0;i < word.length();i++){
                node.children.putIfAbsent(word.charAt(i), new Trie());
                node = node.children.get(word.charAt(i));
                if (i == word.length() - 1){
                    node.val = 1;
                }
            }
        }

        public int match(String word){
            Trie cur = this;
            for (int i = 0;i < word.length();i++){
               if (cur.val == 1){
                   return i;
               }else {
                   if (cur.children.containsKey(word.charAt(i))){
                       cur = cur.children.get(word.charAt(i));
                   }else {
                       break;
                   }
               }
            }
            return 0;
        }
    }

    @Test
    public void test(){

        System.out.println(replaceWords(new ArrayList<>(){{
            add("cat");
            add("bat");
            add("rat");
        }}, "the cattle was rattled by the battery"));
    }
}
