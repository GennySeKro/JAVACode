package rating1500_1700;

import java.util.HashMap;

public class G3043 {
    /*
    最长公共前缀
     */

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        TireNode tireNode = new TireNode();
        int res = 0;
        for (int n : arr1){
            tireNode.addStr(tireNode, String.valueOf(n));
        }

        for (int n : arr2){
            res = Math.max(res, tireNode.sameLen(tireNode, String.valueOf(n)));
        }
        return res;
    }


    private class TireNode{
        private HashMap<Character, TireNode> map;
        private boolean isEnd;

        private TireNode(){
            map = new HashMap<>();
            isEnd = false;
        }

        private void addStr(TireNode tireNode, String string){
            for (int i = 0;i < string.length();i++){
                if (!tireNode.map.containsKey(string.charAt(i))){
                    tireNode.map.put(string.charAt(i), new TireNode());
                }
                tireNode = tireNode.map.get(string.charAt(i));
            }
            tireNode.isEnd = true;
        }

        private int sameLen(TireNode tireNode, String string){
            int len = 0;
            for (int i = 0;i < string.length();i++){
                if (!tireNode.map.containsKey(string.charAt(i))){
                    return len;
                }
                tireNode = tireNode.map.get(string.charAt(i));
                len++;
            }
            return len;
        }
    }
}
