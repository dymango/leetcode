package app.jianzhioffer;

/**
 * @author dimmy
 */
public class SumNums_64 {

    /**
     * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     *
     * 示例 1：
     * 输入: n = 3
     * 输出: 6
     *
     * 示例 2：
     * 输入: n = 9
     * 输出: 45
     *  
     * 限制：
     * 1 <= n <= 10000
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/qiu-12n-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param n
     * @return
     */
    public int sumNums(int n) {
        if(n == 1) return 1;
        int num = n - 1;
        int sum = sumNums(num);
        return n + sum;
    }

}
