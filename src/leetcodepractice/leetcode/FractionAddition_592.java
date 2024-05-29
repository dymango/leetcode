package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class FractionAddition_592 {

    /**
     * 给定一个表示分数加减运算表达式的字符串，你需要返回一个字符串形式的计算结果。 这个结果应该是不可约分的分数，即最简分数。 如果最终结果是一个整数，例如 2，你需要将它转换成分数形式，其分母为 1。所以在上述例子中, 2 应该被转换为 2/1。
     *
     * 示例 1:
     *
     * 输入:"-1/2+1/2"
     * 输出: "0/1"
     *  示例 2:
     *
     * 输入:"-1/2+1/2+1/3"
     * 输出: "1/3"
     * 示例 3:
     *
     * 输入:"1/3+-1/2"
     * 输出: "-1/6"
     * 示例 4:
     *
     * 输入:"5/3+1/3"
     * 输出: "2/1"
     * 说明:
     *
     * 输入和输出字符串只包含 '0' 到 '9' 的数字，以及 '/', '+' 和 '-'。 
     * 输入和输出分数格式均为 ±分子/分母。如果输入的第一个分数或者输出的分数是正数，则 '+' 会被省略掉。
     * 输入只包含合法的最简分数，每个分数的分子与分母的范围是  [1,10]。 如果分母是1，意味着这个分数实际上是一个整数。
     * 输入的分数个数范围是 [1,10]。
     * 最终结果的分子与分母保证是 32 位整数范围内的有效整数。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/fraction-addition-and-subtraction
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param expression
     * @return
     */
    public static String fractionAddition(String expression) {
        int start = 1;
        while (start < expression.length()) {
            if(expression.charAt(start) == '-') {
                expression = expression.substring(0, start) + "+" + expression.substring(start);
                start+=2;
            } else {
                start++;
            }
        }

        String[] strArr = expression.split("\\+");
        String[] pre = new String[2];
        pre[0] = strArr[0].split("/")[0];
        pre[1] = strArr[0].split("/")[1];
        for (int i = 1; i < strArr.length; i++) {
            String[] str = strArr[i].split("/");
            if(!pre[1].equals(str[1])) {
                Integer under = Integer.parseInt(pre[1])*Integer.parseInt(str[1]);
                Integer above = Integer.parseInt(pre[0])*Integer.parseInt(str[1]) + Integer.parseInt(pre[1])*Integer.parseInt(str[0]);
                pre[0] = above + "";
                pre[1] = under + "";
            } else {
                pre[0] = Integer.parseInt(pre[0]) + Integer.parseInt(str[0]) + "";
                pre[1] = pre[1];
            }
        }

        String flag = Integer.parseInt(pre[0]) < 0 ? "-" : "";
        int above=  Math.abs(Integer.parseInt(pre[0]));
        int under = Integer.parseInt( pre[1] );
        int n = GCD(above, under);
        above = above/n;
        under = under/n;
        return flag + above + "/" + under;
    }

    public static void main(String[] args) {
//        fractionAddition("-1/2+1/2");
        System.out.println( fractionAddition("1/3-1/2"));
        System.out.println( fractionAddition("-1/2+1/2"));
        System.out.println( fractionAddition("-1/2+1/2+1/3"));
        System.out.println( fractionAddition("5/3+1/3"));


    }

    public static int GCD(int m, int n) {
        int result = 0;
        while (n != 0) {
            result = m % n;
            m = n;
            n = result;
        }
        return m;


    }
}
