package SlidingWindow;

public class S1156 {
    /*
    单字符重复子串的最大长度
     */

    public int maxRepOpt1(String text) {
        if (text.length() == 1){
            return 1;
        }
        int[] array = new int[26];

        for (int i = 0;i < text.length();i++){
            array[text.charAt(i) - 'a']++;
        }

        int res = 0;
        for (int i = 0;i < text.length();){
            int j = i;
            while (j < text.length() && text.charAt(i) == text.charAt(j)){
                j++;
            }
            int curLen = j - i;
            if (curLen < array[text.charAt(i) - 'a'] && (j < text.length() || i > 0)){
                res = Math.max(res, curLen + 1);
            }
            int k = j + 1;
            while (k < text.length() && text.charAt(k) == text.charAt(i)){
                k++;
            }
            res = Math.max(res, Math.min(k - i, array[text.charAt(i) - 'a']));
            i = j;
        }


        return res;
    }
}
