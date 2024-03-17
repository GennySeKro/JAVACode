package Leetcode.week.week385;

import org.junit.Test;

import java.util.HashMap;

public class HOT100229 {
    /*
    最长公共前缀的长度
     */

    private class TrieNode {
        HashMap<Character, TrieNode> next;
        boolean isEnd;

        public TrieNode() {
            next = new HashMap<>();
            isEnd = false;
        }
    }

    private void addStr(TrieNode node, String w) {
        for (int i = 0; i < w.length(); ++i) {
            char c = w.charAt(i);
            if (!node.next.containsKey(c)) {
                node.next.put(c, new TrieNode());
            }
            node = node.next.get(c);
        }
        node.isEnd = true;
    }

    private int findLen(TrieNode node, String w) {
        int add = 0;
        for (int i = 0; i < w.length(); ++i) {
            char c = w.charAt(i);
            if (!node.next.containsKey(c)) {
                break;
            }
            node = node.next.get(c);
            ++add;
        }
        return add;
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        TrieNode root = new TrieNode();
        for (int n : arr1) {
            addStr(root, String.valueOf(n));
        }

        int res = 0;
        for (int n : arr2) {
            String tmp = String.valueOf(n);
            res = Math.max(res, findLen(root, tmp));
        }
        return res;
    }


    @Test
    public void test(){
        System.out.println(longestCommonPrefix(new int[]{1482,5925,9990},new int[]{2940,3354,1752,3268}));
    }

}
