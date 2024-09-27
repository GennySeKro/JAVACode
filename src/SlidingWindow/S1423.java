package SlidingWindow;

public class S1423 {
    /*
    可获得的最大点数
     */

    public int maxScore(int[] cardPoints, int k) {
        int tempSum = 0, res = 0;

        for (int i = 0;i < k;i++){
            tempSum += cardPoints[i];
        }
        res = Math.max(res, tempSum);

        for (int i = k - 1;i >= 0;i--){
            tempSum = tempSum - cardPoints[i] + cardPoints[cardPoints.length - k + i];
            res = Math.max(res, tempSum);
        }
        return res;
    }
}
