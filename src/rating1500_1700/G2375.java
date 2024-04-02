package rating1500_1700;

import org.junit.Test;

import java.util.Stack;

public class G2375 {
    /*
    根据模式串构造最小数字
     */

    public String smallestNumber(String pattern) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 1;i <= pattern.length() + 1;i++){
            stack.push(i);
        }
        int[] res = new int[stack.size()];
        int len = 0;
        for (int i = pattern.length();i > 0;i--){
            if (pattern.charAt(i - 1) == 'D'){
                len++;
            }else {
                if (len == 0){
                    res[i] = stack.pop();
                }else {
                    int k = 1;
                    res[i] = stack.pop();
                    while (k <= len){
                        res[i + k] = stack.pop();
                        k++;
                    }
                    len = 0;
                }
            }
        }
        len = stack.size();
        for (int i = 0;i < len;i++){
            res[i] = stack.pop();
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0;i < res.length;i++){
            stringBuilder.append(res[i]);
        }
        return stringBuilder.toString();
    }

    @Test
    public void test(){
        System.out.println(smallestNumber("DDD"));
    }
}
