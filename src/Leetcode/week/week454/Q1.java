package Leetcode.week.week454;

public class Q1 {
    /*
    为视频标题生成标签
     */

    public String generateTag(String caption) {
        StringBuilder res = new StringBuilder("#");
        char[] chars = caption.toCharArray();
        for (int i = 0; i < chars.length && res.length() < 100; i++){
            char c = chars[i];
            if (c == ' '){
                continue;
            }
            if (res.length() > 1 && chars[i - 1] == ' '){
                res.append((char) (c & ~32));
            }else {
                res.append((char) (c | 32));
            }
        }

        return res.toString();
    }
}
