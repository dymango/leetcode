package leetcodepractice.twohundred;

/**
 * @author dimmy
 */
public class myPow50 {

    /**
     * 实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public double quickMul(double x, long N) {
       if(N==0) return 1;
        var v = quickMul(x, N / 2);
        return N%2 == 0 ? v * v : v * v * x;
    }
}
