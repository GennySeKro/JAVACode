package LCR;

public class LCR132 {
    /*
    砍竹子Ⅱ
     */

    public int cuttingBamboo(int bamboo_len) {
        if (bamboo_len < 3){
            return 1;
        }
        if (bamboo_len == 3){
            return 3;
        }
        long res = 1;
        while (bamboo_len > 4){
            res *= 3;
            res %= 1000000007;
            bamboo_len -= 3;
        }
        return (int)(bamboo_len * res % 1000000007);
    }
}
