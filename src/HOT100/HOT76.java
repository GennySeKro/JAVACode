package HOT100;

public class HOT76 {
    /*
    最小覆盖子串
     */

    public String minWindow(String s, String t) {
        if (s.length() < t.length()){
            return "";
        }

        char[] sCharArray = s.toCharArray();
        int[] sCharNum = new int[128];
        int[] tCharArray = new int[128];

        for (char c : t.toCharArray()){
            tCharArray[c]++;
        }

        int ansLeft = -1, ansRight = s.length();
        int left = 0;
        for (int right = 0; right < s.length(); right++){
            sCharNum[sCharArray[right]]++;
            while (isCoverd(sCharNum, tCharArray)){
                if (right - left < ansRight - ansLeft){
                    ansLeft = left;
                    ansRight = right;
                }
                sCharNum[sCharArray[left]]--;
                left++;
            }
        }

        return ansLeft < 0 ? "" : s.substring(ansLeft, ansRight + 1);
    }

    private boolean isCoverd(int[] sCharNum, int[] sCharArray) {
        for (int i = 'a';i <= 'z'; i++){
            if (sCharNum[i] < sCharArray[i]){
                return false;
            }
        }

        for (int i = 'A';i <= 'Z'; i++){
            if (sCharNum[i] < sCharArray[i]){
                return false;
            }
        }

        return true;
    }
}
