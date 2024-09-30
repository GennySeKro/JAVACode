package SlidingWindow;

import org.junit.Test;

import java.util.HashMap;

public class S1358 {
    /*
    包含所有三种字符的子字符串数目
     */

    public int numberOfSubstrings(String s) {
        int ans = 0;
        int left = 0;
        int[] cnt = new int[3];
        for(int right = 0; right < s.length(); right++){
            cnt[s.charAt(right)-'a']++;
            while(cnt[0] > 0 && cnt[1] > 0 && cnt[2] > 0){
                cnt[s.charAt(left)-'a']--;
                left++;
            }
            ans += left;
        }
        return ans;
    }

    @Test
    public void test(){
        System.out.println(numberOfSubstrings("acbbcac"));
    }
}
