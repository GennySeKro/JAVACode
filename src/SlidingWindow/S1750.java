package SlidingWindow;

import org.junit.Test;

public class S1750 {
    /*
    删除字符串两端相同字符后的最短长度
     */

    public int minimumLength(String s) {
        char[] chars = s.toCharArray();
        int l = 0, r = chars.length - 1;
        while (l < r && chars[l] == chars[r]) {
            //获取当前能够删除的最大数量，尽可能删除相同的元素
            while (l + 1 <= r && chars[l + 1] == chars[l]) l++;
            while (r - 1 >= l && chars[r - 1] == chars[r]) r--;
            //收缩两端点，进行下一次删除
            l++;
            r--;
        }
        //返回l - r之间的元素个数
        int res = r - l + 1;
        //判断结果
        return Math.max(res, 0);
    }

    @Test
    public void test(){
        System.out.println(minimumLength("bbb"));
    }
}
