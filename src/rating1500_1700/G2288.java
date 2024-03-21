package rating1500_1700;

import org.junit.Test;

public class G2288 {
    /*
    价格减免
     */

    public String discountPrices(String sentence, int discount) {
        String[] str = sentence.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = 0;i < str.length;i++){
            boolean flag = false;
            double sum = 0;
            if (str[i].charAt(0) == '$' && str[i].length() >= 2){
                int j;
                for (j = 1;j < str[i].length();j++){
                    if (str[i].charAt(j) <= '9' && str[i].charAt(j) >= '0'){
                        sum = sum * 10 + str[i].charAt(j) - '0';
                    }else {
                        break;
                    }
                }
                if (j == str[i].length()){
                    flag = true;
                }else {
                    flag = false;
                }
            }
            if (flag == true)
            {
                sum = sum * (100 - discount) / 100;
                res.append('$').append(String.format("%.2f", sum)).append(" ");
            }else {
                res.append(str[i]).append(" ");
            }
        }
        return res.deleteCharAt(res.length() - 1).toString();
    }

    @Test
    public void test(){
        System.out.println(discountPrices("there are $1 $2 and 5$ candies in the shop", 50));
    }
}
