public class HOT242 {
    /*
    有效的字母异位词
     */

    public boolean isAnagram(String s, String t) {
        int[] res = new int[26];
        for(int i = 0;i < s.length();i++){
            res[s.charAt(i)-'a']++;
        }
        for(int i = 0;i < t.length();i++){
            res[t.charAt(i)-'a']--;
        }
        for(int i = 0;i < res.length;i++){
            if(res[i] != 0){
                return false;
            }
        }
        return true;
    }
}
