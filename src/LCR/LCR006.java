package LCR;

public class LCR006 {
    /*
    输入有序数组
     */

    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right){
            if (numbers[left] + numbers[right] == target){
                return new int[]{left, right};
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            }else {
                left++;
            }
        }
        return new int[0];
    }
}
