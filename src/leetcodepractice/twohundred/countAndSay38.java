package leetcodepractice.twohundred;

/**
 * @author dimmy
 */
public class countAndSay38 {

    /**
     * 「外观数列」是一个数位字符串序列，由递归公式定义：
     * <p>
     * countAndSay(1) = "1"
     * countAndSay(n) 是 countAndSay(n-1) 的行程长度编码。
     * <p>
     * <p>
     * 行程长度编码（RLE）是一种字符串压缩方法，其工作原理是通过将连续相同字符（重复两次或更多次）替换为字符重复次数（运行长度）和字符的串联。例如，要压缩字符串 "3322251" ，我们将 "33" 用 "23" 替换，将 "222" 用 "32" 替换，将 "5" 用 "15" 替换并将 "1" 用 "11" 替换。因此压缩后字符串变为 "23321511"。
     * <p>
     * 给定一个整数 n ，返回 外观数列 的第 n 个元素。
     * <p>
     * 示例 1：
     *
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        String pre = "1";
        for (int i = 2; i <= n; i++) {
            pre =  cal(pre);
        }

        return pre;
    }

    private String cal(String str) {
        StringBuilder s = new StringBuilder();
        var charArray = str.toCharArray();
        int count = 0;
        for (int i = 0; i < charArray.length; i++) {
            var c = charArray[i];
            if(count == 0 || c == charArray[i - 1]) {
                count++;
            }

            if(i + 1 >= charArray.length || c != charArray[i + 1]) {
                s.append(count);
                s.append(charArray[i]);
                count = 0;
            }
        }

        return s.toString();
    }

    public static void main(String[] args) {
        System.out.println(new countAndSay38().cal("3322251"));
    }
}
