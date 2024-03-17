package LCR;

public class LCR158 {
    /*
    库存管理Ⅱ
     */

    public int inventoryManagement(int[] stock) {
        int num = 1;
        int res = stock[0];
        for (int i = 1;i < stock.length;i++){
            if (num == 0){
                num = 1;
                res = stock[i];
            }else {
                if (stock[i] == res){
                    num++;
                }else {
                    num--;
                }
            }
        }
        return res;
    }
}
