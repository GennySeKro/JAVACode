package LCR;

import org.junit.Test;

public class LCR182 {
    /*
    动态口令
     */

    public String dynamicPassword(String password, int target) {
        password = password + " ";
        String res = password.substring(target, password.length() - 1) + password.substring(0, target);
        return res;
    }

    @Test
    public void test(){
        System.out.println(dynamicPassword("s3cur1tyC0d3", 4));
    }
}
