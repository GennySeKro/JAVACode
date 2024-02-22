import java.util.HashSet;
import java.util.Set;

public class HOT383 {
    /*
    赎金信
     */

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] array = new int[26];
        for(int i = 0;i < magazine.length();i++){
            array[magazine.charAt(i)-'a']++;
        }
        for(int i = 0;i < ransomNote.length();i++){
            array[ransomNote.charAt(i)-'a'] = array[ransomNote.charAt(i)-'a'] - 1;
            if(array[ransomNote.charAt(i)-'a'] < 0){
                return false;
            }
        }
        return true;
    }
}
