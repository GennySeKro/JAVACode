package SlidingWindow;

import org.junit.Test;

public class S2379 {
    /*
    得到K个黑块的最少涂色次数
     */

    public int minimumRecolors(String blocks, int k) {

        int res = Integer.MAX_VALUE;
        int whiteBlockNum = 0;
        for (int i = 0;i < blocks.length();i++){
            if (i < k){
                if (blocks.charAt(i) == 'W'){
                    whiteBlockNum++;
                }
            }else {
                res = Math.min(res, whiteBlockNum);
                if (blocks.charAt(i - k) == 'W'){
                    whiteBlockNum--;
                }
                if (blocks.charAt(i) == 'W'){
                    whiteBlockNum++;
                }
                res = Math.min(res, whiteBlockNum);
            }
        }
        res = Math.min(res, whiteBlockNum);
        return res;
    }

    @Test
    public void test(){
        System.out.println(minimumRecolors("BBBBBWWBBWBWBWWWBWBWBBBBWBBBBWBWBWBWBWWBWWBWBWWWWBBWWWWBWWWWBWBBWBBWBBWWW", 29));
    }
}
