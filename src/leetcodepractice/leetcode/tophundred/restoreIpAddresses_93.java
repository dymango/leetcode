package leetcodepractice.leetcode.tophundred;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimmy
 */
public class restoreIpAddresses_93 {

    /**
     * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
     * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
     * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
     *
     * @param s
     * @return
     */
    List<String> r = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        int length = s.length();
        for (int i = 0; i < 3; i++) {
            boolean checki = check(s, 0, i + 1);
            if (!checki) continue;
            for (int j = i + 1; j < i + 4; j++) {
                boolean checkj = check(s, i + 1, j + 1);
                if (!checkj) continue;
                for (int k = j + 1; k < j + 4; k++) {
                    if (k > length - 2) continue;
                    boolean checkk = check(s, j + 1, k + 1);
                    boolean checkl = check(s, k + 1, length);
                    String e = s.substring(0, i + 1) + "." + s.substring(i + 1, j + 1) + "." + s.substring(j + 1, k + 1) + "." + s.substring(k + 1, length);
                    System.out.println(e);
                    if (!checkk || !checkl) continue;
                    r.add(e);
                }
            }
        }

        return r;
    }

    private boolean check(String s, int start, int end) {
        if (end > s.length()) return false;
        if (end - start > 3) return false;
        String str = s.substring(start, end);
        if (!str.equals("0") && str.startsWith("0")) return false;
        long l = Long.parseLong(str);
        if (l < 0 || l > 255) return false;
        return true;
    }


    public static void main(String[] args) {
        new restoreIpAddresses_93().restoreIpAddresses("25525511135");
    }
}
