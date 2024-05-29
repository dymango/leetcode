package leetcodepractice.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dimmy
 */
public class HasGroupsSizeX_914 {

    /**
     * 给定一副牌，每张牌上都写着一个整数。
     * <p>
     * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
     * <p>
     * 每组都有 X 张牌。
     * 组内所有的牌上都写着相同的整数。
     * 仅当你可选的 X >= 2 时返回 true。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：deck = [1,2,3,4,4,3,2,1]
     * 输出：true
     * 解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
     * 示例 2：
     * <p>
     * 输入：deck = [1,1,1,2,2,2,3,3]
     * 输出：false
     * 解释：没有满足要求的分组。
     * <p>
     * 提示：
     * <p>
     * 1 <= deck.length <= 104
     * 0 <= deck[i] < 104
     *
     * @param deck
     * @return
     */
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int d : deck) {
            countMap.merge(d, 1, Integer::sum);
        }

        int result = 1;
        for (int i = result; i <= deck.length; i++) {
            int group = i;
            if (countMap.entrySet().stream().allMatch(entry -> entry.getValue() == group || entry.getValue() % group == 0)) {
                result = i;
            }
        }

        return result >= 2;
    }

    public boolean hasGroupsSizeXV2(int[] deck) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int d : deck) {
            countMap.merge(d, 1, Integer::sum);
        }

        int result = 1;
        for (int i = result; i <= deck.length; i++) {
            int group = i;
            if (countMap.entrySet().stream().allMatch(entry -> entry.getValue() == group || entry.getValue() % group == 0)) {
                result = i;
            }

            if (result >= 2) return true;
        }

        return false;
    }

    public boolean hasGroupsSizeXV3(int[] deck) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int d : deck) {
            countMap.merge(d, 1, Integer::sum);
        }

        int length = deck.length;
        for (int i = 1; i <= length; i++) {
            if (length % i != 0) continue;
            int group = i;
            if (countMap.entrySet().stream().allMatch(entry -> entry.getValue() == group || entry.getValue() % group == 0)) {
                if (i >= 2) return true;
            }
        }

        return false;
    }
}