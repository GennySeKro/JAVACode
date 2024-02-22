import java.util.HashSet;
import java.util.Set;

public class HOT128 {
    /*
    最长连续序列
     */

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int max_length = 0;

        for (int num : numSet) {
            // 如果num-1存在于集合中，说明num不是一个序列的起始数字，可以跳过
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;

                // 检查比当前数字大1的数字是否存在于集合中，依次递增序列长度
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }

                max_length = Math.max(max_length, currentLength);
            }
        }

        return max_length;
    }
}
