package leetcodepractice.twohundred;

/**
 * @author dimmy
 */
public class compareVersion165 {

    /**
     * 给你两个 版本号字符串 version1 和 version2 ，请你比较它们。版本号由被点 '.' 分开的修订号组成。修订号的值 是它 转换为整数 并忽略前导零。
     * 比较版本号时，请按 从左到右的顺序 依次比较它们的修订号。如果其中一个版本字符串的修订号较少，则将缺失的修订号视为 0。
     * 返回规则如下：
     * <p>
     * 如果 version1 < version2 返回 -1，
     * 如果 version1 > version2 返回 1，
     * 除此之外返回 0。
     * <p>
     * "1.0"
     * version2 =
     * "1.0.0.0"
     * <p>
     * 添加到测试用例
     * 输出
     *
     * @param version1
     * @param version2
     * @return
     */


    public static void main(String[] args) {
        System.out.println(new compareVersion165().compareVersion("1.2", "1.10"));
    }

    public int compareVersion(String version1, String version2) {
        var v1 = version1.split("\\.");
        var v2 = version2.split("\\.");
        var index = 0;
        while (true) {
            if (index >= v1.length && index >= v2.length) return 0;
            var i = index >= v1.length ? 0 : Integer.parseInt(v1[index]);
            var i2 = index >= v2.length ? 0 : Integer.parseInt(v2[index]);
            if (i != i2) {
                return Integer.compare(i, i2);
            }
            index++;
        }
    }
}
