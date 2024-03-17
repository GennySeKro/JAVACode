package Leetcode.week.week385;

import org.junit.Test;

public class HOT100212 {
    /*
    统计前后缀下标对
     */

    public int countPrefixSuffixPairs(String[] words) {
        int res = 0;
        for (int i = 0;i < words.length - 1;i++){
            for (int j = i + 1;j < words.length;j++){
                if (isPrefixAndSuffix(words[i], words[j])){
                    res++;
                }
            }

        }
        return res;
    }

    private boolean isPrefixAndSuffix(String str1, String str2){
        if (str1.length() > str2.length()){
            return false;
        }
        for (int i = 0;i < str1.length();i++){
            if (str1.charAt(i) != str2.charAt(i) || str1.charAt(str1.length() - i - 1) != str2.charAt(str2.length() - i - 1)){
                return false;
            }
        }
        return true;
    }

    @Test
    public void test(){
        System.out.println(countPrefixSuffixPairs(new String[]{"a","aba","ababa","aa"}));
    }
}
