package Binary;

public class B2064 {
    /*
    分配给商店的最多商品的最小值
     */

    public int minimizedMaximum(int n, int[] quantities) {
        long maxQuantity = 0, minQuantity = 1;
        for (int quantity : quantities){
            maxQuantity += quantity;
        }

        while (minQuantity <= maxQuantity){
            long midQuantity = (minQuantity + maxQuantity) >>> 1;
            int k = 0;
            for (int num : quantities){
                k += (int) ((num + midQuantity - 1) / midQuantity);
            }
            if (k > n){
                minQuantity = midQuantity + 1;
            }else {
                maxQuantity = midQuantity - 1;
            }
        }

        return (int) minQuantity;
    }
}
