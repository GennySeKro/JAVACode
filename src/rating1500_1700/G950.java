package rating1500_1700;

import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class G950 {
    /*
    按递增顺序显示卡牌
     */

    public int[] deckRevealedIncreasing(int[] deck) {
        int N = deck.length;
        Deque<Integer> index = new LinkedList();
        for (int i = 0; i < N; ++i)
            index.add(i);

        int[] ans = new int[N];
        Arrays.sort(deck);
        for (int card: deck) {
            ans[index.pollFirst()] = card;
            if (!index.isEmpty())
                index.add(index.pollFirst());
        }

        return ans;
    }

    @Test
    public void test(){
        System.out.println(Arrays.toString(deckRevealedIncreasing(new int[]{17, 13, 11, 2, 3, 5, 7})));
    }
}
