package app.leetcode;

/**
 * @author dimmy
 */
public class HammingDistance_461 {

    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
