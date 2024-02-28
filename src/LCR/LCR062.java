package LCR;

import java.util.HashMap;
import java.util.Map;

public class LCR062 {
    /*
    实现Tire(前缀树)
     */

    class Trie {

        private boolean isEnd;
        private Map<Character, Trie> children;

        public Trie() {
            isEnd = false;
            children = new HashMap<Character, Trie>();
        }

        public void insert(String word) {
            Trie node = this;
            int length = word.length();
            for (int i = 0; i < length; i++) {
                char c = word.charAt(i);
                node.children.putIfAbsent(c, new Trie());
                node = node.children.get(c);
            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            Trie node = searchPrefix(word);
            return node != null && node.isEnd;
        }

        public boolean startsWith(String prefix) {
            Trie node = searchPrefix(prefix);
            return node != null;
        }

        private Trie searchPrefix(String prefix) {
            Trie node = this;
            int length = prefix.length();
            for (int i = 0; i < length; i++) {
                char c = prefix.charAt(i);
                if (!node.children.containsKey(c)) {
                    return null;
                }
                node = node.children.get(c);
            }
            return node;
        }
    }
}
