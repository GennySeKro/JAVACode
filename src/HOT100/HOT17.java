package HOT100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HOT17 {
    /*
    电话号码的字母组合
     */

    private String[] str = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private ArrayList<String> res = new ArrayList<>();
    private StringBuilder path = new StringBuilder();
    public List<String> letterCombinations(String digits) {

        if (digits.isEmpty()){
            return res;
        }

        backTrack(digits, 0);
        return res;
    }

    private void backTrack(String digits, int index) {
        if (index == digits.length()){
            res.add(path.toString());
            return;
        }

        String tempStr = str[digits.charAt(index) - '2'];
        for (int i = 0;i < tempStr.length();i++){
            path.append(tempStr.charAt(i));
            backTrack(digits, index + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
