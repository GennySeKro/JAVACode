import org.junit.Test;
import java.util.Arrays;

public class HOT3035 {
    /*
    回文字符串的最大数量
     */

    public int maxPalindromesAfterOperations(String[] words) {
        int[] num = new int[26];
        int[] len = new int[words.length];
        int res = 0;
        for (int i = 0;i < words.length;i++){
            len[i] = words[i].length();
            for (int j = 0;j < words[i].length();j++){
                num[words[i].charAt(j) - 'a']++;
            }
        }
        Arrays.sort(len);
        for (int i = 0;i < len.length;i++){
            //本次能否拼成回文字符串
            int k = 0;
            int needSum = len[i];
            if (len[i] % 2 == 0){
                for (int j = 0;j < num.length;j++){
                    if (needSum == 0){
                        k = 1;
                        break;
                    }
                    if (num[j] == 0){
                        continue;
                    }
                    if (needSum <= num[j]){
                        k = 1;
                        num[j] = num[j] - needSum;
                        break;
                    }else {
                        if (num[j] % 2 == 0){
                            needSum = needSum - num[j];
                            num[j] = 0;
                        }else {
                            needSum = needSum - num[j] + 1;
                            num[j] = 1;
                        }
                    }
                }
            }else {
                //标记找到中心字母索引
                int flag = -1;
                for (int j = 0;j < num.length;j++){
                    if (num[j] == 1){
                        needSum = needSum - 1;
                        num[j] = 0;
                        flag = j;
                        break;
                    }
                }
                if (flag == -1){
                    for (int j = 0;j < num.length;j++){
                        if (num[j] % 2 != 0){
                            num[j] = num[j] - 1;
                            flag = j;
                            needSum = needSum - 1;
                            break;
                        }
                    }
                }
                if (flag == -1){
                    for (int j = 0;j < num.length;j++){
                        if (num[j]  != 0){
                            num[j] = num[j] - 1;
                            flag = j;
                            needSum = needSum - 1;
                            break;
                        }
                    }
                }
                for (int j = 0;j < num.length;j++){
                    if (needSum == 0){
                        k = 1;
                        break;
                    }
                    if (num[j] == 0){
                        continue;
                    }
                    if (needSum <= num[j]){
                        k = 1;
                        num[j] = num[j] - needSum;
                        break;
                    }else {
                        if (num[j] % 2 == 0){
                            needSum = needSum - num[j];
                            num[j] = 0;
                        }else {
                            needSum = needSum - num[j] + 1;
                            num[j] = 1;
                        }
                    }
                }
            }
            if (k == 1){
                res++;
            }
        }
        return res;
    }


    @Test
    public void test(){
        System.out.println(maxPalindromesAfterOperations(new String[]{"a","b"}));
    }
}
