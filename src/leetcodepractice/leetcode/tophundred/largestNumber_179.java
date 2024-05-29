package leetcodepractice.leetcode.tophundred;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimmy
 */
public class largestNumber_179 {

    /**
     * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
     * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
     *
     * @param nums
     * @return
     */
    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int num : nums) {
            list.add(String.valueOf(num));
        }

        list.sort((o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        if (list.stream().allMatch(s -> s.equals("0"))) return "0";
        return String.join("", list);
    }
}
