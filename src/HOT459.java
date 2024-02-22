public class HOT459 {
    /*
    重复的子字符串
     */

    public boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }
}
