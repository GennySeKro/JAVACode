package HOT119;

public class LCR002 {
    /*
    二进制求和
     */

    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder(); // 返回结果
        int i = a.length() - 1; // 标记遍历到 a 的位置
        int j = b.length() - 1; // 标记遍历到 b 的位置
        int carry = 0; // 进位
        while (i >= 0 || j >= 0 || carry != 0) { // a 没遍历完，或 b 没遍历完，或进位不为 0
            int digitA = i >= 0 ? a.charAt(i) - '0' : 0; // 当前 a 的取值
            int digitB = j >= 0 ? b.charAt(j) - '0' : 0; // 当前 b 的取值
            int sum = digitA + digitB + carry; // 当前位置相加的结果
            carry = sum >= 2 ? 1 : 0; // 是否有进位
            sum = sum >= 2 ? sum - 2 : sum; // 去除进位后留下的数字
            res.append(sum); // 把去除进位后留下的数字拼接到结果中
            i --;  // 遍历到 a 的位置向左移动
            j --;  // 遍历到 b 的位置向左移动
        }
        return res.reverse().toString(); // 把结果反转并返回
    }
}
