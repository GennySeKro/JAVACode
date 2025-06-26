package Leetcode.fortnight.f159;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q3 {
    /*
    计数质数间隔平衡子数组
     */

    private static final int MX = 50_001;
    private static final boolean[] NOT_PRIME = new boolean[MX];
    private static boolean initialized = false;

    //预处理1-50001之间的数，标记质数为false， 非质数为true
    private void init(){
        if (initialized){
            return;
        }

        initialized = true;
        NOT_PRIME[1] = true;
        for (int i = 2; i * i < MX; i++){
            if (NOT_PRIME[i]){
                continue;
            }
            for (int j = i * i; j < MX; j += i){
                NOT_PRIME[j] = true;
            }
        }
    }

    public int primeSubarray(int[] nums, int k) {
        init();

        Deque<Integer> minQ = new ArrayDeque<>();
        Deque<Integer> maxQ = new ArrayDeque<>();
        int last = -1, last2 = -1;
        int ans = 0, left = 0;

        for (int i = 0; i < nums.length; i++){
            int x = nums[i];

            if (!NOT_PRIME[x]){
                last2 = last;
                last = i;

                while (!minQ.isEmpty() && x <= nums[minQ.peekLast()]){
                    minQ.pollLast();
                }
                minQ.addLast(i);

                while (!maxQ.isEmpty() && x >= nums[maxQ.peekLast()]){
                    maxQ.pollLast();
                }
                maxQ.addLast(i);

                while (nums[maxQ.peekFirst()] - nums[minQ.peekFirst()] > k){
                    left++;
                    if (minQ.peekFirst() < left){
                        minQ.pollFirst();
                    }
                    if (maxQ.peekFirst() < left){
                        maxQ.pollFirst();
                    }
                }
            }

            ans += last2 - left + 1;
        }

        return ans;
    }
}
