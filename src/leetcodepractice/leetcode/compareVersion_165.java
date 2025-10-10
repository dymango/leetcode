package leetcodepractice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimmy
 */
public class compareVersion_165 {

    /**
     * 给你两个 版本号字符串 version1 和 version2 ，请你比较它们。版本号由被点 '.' 分开的修订号组成。修订号的值 是它 转换为整数 并忽略前导零。
     * 比较版本号时，请按 从左到右的顺序 依次比较它们的修订号。如果其中一个版本字符串的修订号较少，则将缺失的修订号视为 0。
     * 返回规则如下：
     * <p>
     * 如果 version1 < version2 返回 -1，
     * 如果 version1 > version2 返回 1，
     * 除此之外返回 0。
     *
     * @param version1
     * @param version2
     * @return
     */


    public int compareVersion(String version1, String version2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        var split = version1.split("\\.");
        for (String s : split) {
            l1.add(Integer.valueOf(s));
        }

        var split2 = version2.split("\\.");
        for (String s : split2) {
            l2.add(Integer.valueOf(s));
        }

        if (l2.size() < l1.size()) {
            var dif = l1.size() - l2.size();
            for (int i = 0; i < dif; i++) {
                l2.add(0);
            }
        } else if (l2.size() > l1.size()) {
            var dif = l2.size() - l1.size();
            for (int i = 0; i < dif; i++) {
                l1.add(0);
            }
        }

        for (int i = 0; i < l1.size(); i++) {
            var x = l1.get(i);
            var y = l2.get(i);
            var compare = Integer.compare(x, y);
            if (compare == 0) continue;
            return compare;
        }

        return 0;
    }


    public static void main(String[] args) {
        new compareVersion_165().compareVersion("1.2", "1.10");
    }
}
