package SlidingWindow;

import org.junit.Test;

public class S2024 {
    /*
    考试的最大困扰度
     */

    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(maxLen(answerKey, k, 'T'), maxLen(answerKey, k, 'F'));
    }

    private int maxLen(String answerKey, int k, char t) {
        int res = 1, tempNum = 0;
        int left = 0, right = 0;

        while (right < answerKey.length()) {
            if (answerKey.charAt(right) != t) {
                tempNum++;
                if (tempNum > k) {
                    res = Math.max(res, right - left);
                    while (tempNum > k) {
                        if (answerKey.charAt(left) != t) {
                            tempNum--;
                        }
                        left++;
                    }

                }
            }
            right++;
        }
        res = Math.max(res, right - left);
        return res;
    }

    @Test
    public void test(){
        System.out.println(maxConsecutiveAnswers("TFFT", 1));
    }
}
