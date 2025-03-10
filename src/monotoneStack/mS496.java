package monotoneStack;

import java.util.ArrayDeque;
import java.util.HashMap;

public class mS496 {
    /*
    下一个更大元素Ⅰ
     */

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];

        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0;i < nums2.length; i++){
            if (stack.isEmpty() || nums2[stack.peekLast()] > nums2[i]){
                stack.addLast(i);
            }
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peekLast()]){
                map.put(nums2[stack.peekLast()], nums2[i]);
                stack.pollLast();
            }
            stack.addLast(i);
        }

        for (int i = 0;i < nums1.length; i++){
            if (map.containsKey(nums1[i])){
                res[i] = map.get(nums1[i]);
            }else {
                res[i] = -1;
            }
        }

        return res;
    }
}
