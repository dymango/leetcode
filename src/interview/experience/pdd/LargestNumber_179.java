package interview.experience.pdd;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimmy
 */
public class LargestNumber_179 {

    /**
     * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
     * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [10,2]
     * 输出："210"
     * 示例 2：
     * <p>
     * 输入：nums = [3,30,34,5,9]
     * 输出："9534330"
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 100
     * 0 <= nums[i] <= 109
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/largest-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num + "");
        }

        if (list.stream().allMatch(requestedBy -> requestedBy.equals("0"))) return "0";
        list.sort((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o2.compareTo(o1);
            } else {
                int maxLength = Math.max(o1.length(), o2.length());
                if (o1.length() < maxLength) {
                    StringBuilder o1Builder = new StringBuilder(o1);
                    o1Builder.append("9".repeat(Math.max(0, maxLength - o1Builder.length())));
                    o1 = o1Builder.toString();
                }

                if (o2.length() < maxLength) {
                    StringBuilder o2Builder = new StringBuilder(o1);
                    o2Builder.append("9".repeat(Math.max(0, maxLength - o2Builder.length())));
                    o2 = o2Builder.toString();
                }

                return o2.compareTo(o1);
            }
        });
        return String.join("", list);
    }

    public static void main(String[] args) {
        System.out.println(new LargestNumber_179().largestNumber(new int[]{10, 2}));
        System.out.println(new LargestNumber_179().largestNumber(new int[]{3, 30, 34, 5, 9}));
    }
}
