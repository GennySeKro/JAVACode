package LCR;

import java.util.HashMap;
import java.util.Map;

public class LCR066 {
    /*
    键值映射
     */

    class MapSum {
        private Map<String, Integer> pairs;
        private Trie trie;

        public MapSum() {
            pairs = new HashMap<String, Integer>();
            trie = new Trie();
        }

        public void insert(String key, int val) {
            int prevVal = pairs.getOrDefault(key, 0);
            pairs.put(key, val);
            trie.insert(key, val - prevVal);
        }

        public int sum(String prefix) {
            return trie.sum(prefix);
        }
    }

    class Trie {
        private int val;
        private Map<Character, Trie> children;

        public Trie() {
            val = 0;
            children = new HashMap<Character, Trie>();
        }

        public void insert(String key, int delta) {
            Trie node = this;
            int length = key.length();
            for (int i = 0; i < length; i++) {
                char c = key.charAt(i);
                node.children.putIfAbsent(c, new Trie());
                node = node.children.get(c);
                node.val += delta;
            }
        }

        public int sum(String prefix) {
            Trie node = this;
            int length = prefix.length();
            for (int i = 0; i < length; i++) {
                char c = prefix.charAt(i);
                if (!node.children.containsKey(c)) {
                    return 0;
                }
                node = node.children.get(c);
            }
            return node.val;
        }
    }
}
