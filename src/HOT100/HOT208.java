package HOT100;

public class HOT208 {
    /*
    实现Trie前缀树
     */

    class Trie {

        private Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            Node cur = root;
            for (char c : word.toCharArray()){
                c -= 'a';
                if (cur.son[c] == null){
                    cur.son[c] = new Node();
                }
                cur = cur.son[c];
            }
            cur.end = true;
        }

        public boolean search(String word) {
            return find(word) == 2;
        }

        public boolean startsWith(String prefix) {
            return find(prefix) != 0;
        }

        private int find(String word) {
            Node cur = root;
            for (char c : word.toCharArray()){
                c -= 'a';
                if (cur.son[c] == null){
                    return 0;
                }
                cur = cur.son[c];
            }
            return cur.end ? 2 : 1;
        }
    }

    class Node{
        Node[] son = new Node[26];
        boolean end;
    }
}
