package HOT;

import org.junit.Test;

import java.util.*;

public class HOT763 {
    /*
    划分字母区间
     */

    /*
    1.找到每个字母的首次和最终出现的位置区间
    2.按照首次出现位置排序
    3.判断区间是否重叠，重叠则更新右边界，否则加入res
    时间复杂度O(n)
    空间复杂度O(1)
     */
    class one{
        public List<Integer> partitionLabels(String s) {
            List<Integer> res = new ArrayList<>();
            int[][] word = new int[26][2];
            for(int i = 0;i < word.length;i++){
                for(int j = 0;j < 2;j++){
                    word[i][j] = -1;
                }
            }

            for(int i = 0;i < s.length();i++){
                if(word[s.charAt(i)-'a'][0] != -1){
                    word[s.charAt(i)-'a'][1] = Math.max(i,word[s.charAt(i)-'a'][1]);
                }else {
                    word[s.charAt(i)-'a'][0] = i;
                    word[s.charAt(i)-'a'][1] = i;
                }
            }
            Arrays.sort(word,(a,b)->Integer.compare(a[0],b[0]));

            int k = 0;
            int sum = 0;
            int left = 0,right = 0;
            for(int i = 0;i < word.length;i++){
                if(word[i][0] != -1 && k == 0){
                    k = 1;
                    left = word[i][0];
                    right = word[i][1];
                }else {
                    if(k == 1){
                        if(word[i][0] < right || word[i][1] < right){
                            right = Math.max(right,word[i][1]);
                        }else {
                            res.add(right-left+1);
                            sum = sum + right-left+1;
                            right = word[i][1];
                            left = word[i][0];
                        }
                    }
                }
            }
            res.add(s.length()-sum);
            return res;
        }
    }

    /*
    1.统计每一个字符最后出现的位置
    2.从头遍历字符，并更新字符的最远出现下标，如果找到字符最远出现位置下标和当前下标相等了，则找到了分割点
    时间复杂度O(n)
    空间复杂度O(1)
     */
    class two{
        public List<Integer> partitionLabels(String s) {
            List<Integer> list = new LinkedList<>();
            int[] edge = new int[26];
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                edge[chars[i] - 'a'] = i;
            }
            int idx = 0;
            int last = -1;
            for (int i = 0; i < chars.length; i++) {
                idx = Math.max(idx,edge[chars[i] - 'a']);
                if (i == idx) {
                    list.add(i - last);
                    last = i;
                }
            }
            return list;
        }
    }

    @Test
    public void test(){
        System.out.println(new one().partitionLabels("caedbdedda"));
    }
}
