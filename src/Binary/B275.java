package Binary;

import org.junit.Test;

public class B275 {
    /*
    H指数Ⅱ
     */

    public int hIndex(int[] citations) {
        int minH = 1, maxH = citations[citations.length - 1];

        while (minH <= maxH){
            int midH = (minH + maxH) >>> 1;
            if(isH(midH, citations)){
                midH = minH + 1;
            }else {
                maxH = midH - 1;
            }
        }

        return maxH;
    }

    private boolean isH(int midH, int[] citations) {
        int time = 0;
        for (int citation : citations){
            if (citation >= midH){
                time++;
            }
        }

        return time >= midH;
    }

    @Test
    public void test(){
        System.out.println(hIndex(new int[]{0,1,3,5,6}));
    }


}
