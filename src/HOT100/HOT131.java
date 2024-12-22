package HOT100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HOT131 {
    /*
    分割回文串
     */

    List<List<String>> result;
    LinkedList<String> path;
    boolean[][] dp;

    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        char[] str = s.toCharArray();
        path = new LinkedList<>();
        dp = new boolean[str.length + 1][str.length + 1];
        isPalindrome(str);
        backtracking(s, 0);
        return result;
    }

    public void backtracking(String str, int startIndex) {
        if (startIndex >= str.length()) {
            //如果起始位置大于s的大小，说明找到了一组分割方案
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < str.length(); ++i) {
            if (dp[startIndex][i]) {
                //是回文子串，进入下一步递归
                //先将当前子串保存入path
                path.addLast(str.substring(startIndex, i + 1));
                //起始位置后移，保证不重复
                backtracking(str, i + 1);
                path.pollLast();
            }
        }
    }

    //通过动态规划判断是否是回文串,参考动态规划篇 52 回文子串
    public void isPalindrome(char[] str) {
        for (int i = 0; i <= str.length; ++i) {
            dp[i][i] = true;
        }
        for (int i = 1; i < str.length; ++i) {
            for (int j = i; j >= 0; --j) {
                if (str[j] == str[i]) {
                    if (i - j <= 1) {
                        dp[j][i] = true;
                    } else if (dp[j + 1][i - 1]) {
                        dp[j][i] = true;
                    }
                }
            }
        }
    }
}
