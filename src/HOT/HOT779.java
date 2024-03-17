package HOT;

public class HOT779 {
    /*
    第K个语法符号
     */

    public int kthGrammar(int n, int k) {
        if (n == 1) {
            return 0;
        }
        return (k & 1) ^ 1 ^ kthGrammar(n - 1, (k + 1) / 2);
    }
}
