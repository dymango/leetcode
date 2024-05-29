package leetcodepractice.leetcode.tophundred;

/**
 * @author dimmy
 */
public class hammingWeight_191 {

    public int hammingWeight(int n) {
        int ret = 0;
        while (n != 0) {
            n &= n - 1;
            ret++;
        }
        return ret;
    }

    //grep -P '^([0-9]{3}-|\([0-9]{3}\) )[0-9]{3}-[0-9]{4}$' file.txt
    //COLUMNS=$(head -n 1 file.txt| wc -w)
    //
    //for i in $(seq 1 $COLUMNS); do
    //    # 获取第i列，然后用paste合并
    //    cut -d ' ' -f"$i" file.txt | paste -s -d' ' -
    //done

}
