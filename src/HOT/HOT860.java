package HOT;

import org.junit.Test;

public class HOT860 {
    /*
    柠檬水找零
     */

    public boolean lemonadeChange(int[] bills) {
        int[] money = new int[3];
        for(int i = 0;i < bills.length;i++){
            if(bills[i] == 5){
                money[0]++;
                continue;
            }
            if(bills[i] == 10){
                if(money[0] != 0){
                    money[0]--;
                    money[1]++;
                    continue;
                }else {
                    return false;
                }
            }
            if(bills[i] == 20){
                if(money[0] != 0 && money[1] != 0){
                    money[0]--;
                    money[1]--;
                    money[2]++;
                }else if (money[0] >= 3){
                    money[0] = money[0] - 3;
                    continue;
                }else {
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    public void test(){
        System.out.println(lemonadeChange(new int[]{5,5,10,10,20}));
    }
}
