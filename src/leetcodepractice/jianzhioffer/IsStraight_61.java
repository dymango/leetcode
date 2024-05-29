package leetcodepractice.jianzhioffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dimmy
 */
public class IsStraight_61 {

    /**
     * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
     *
     * 示例 1:
     *
     * 输入: [1,2,3,4,5]
     * 输出: True
     *  
     *
     * 示例 2:
     *
     * 输入: [0,0,1,2,5]
     * 输出: True
     *  
     *
     * 限制：
     *
     * 数组长度为 5 
     *
     * 数组的数取值为 [0, 13] .
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/bu-ke-pai-zhong-de-shun-zi-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public boolean isStraight(int[] nums) {
        int min = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if(num != 0) min = Math.min(min, num);
            map.merge(num, 1, Integer::sum);
        }

        for (int i = min; i < min + 5; i++) {
            Integer integer = map.get(i);
            if(integer == null || integer == 0) {
                Integer zero = map.get(0);
                if(zero == null || zero == 0) return false;
                map.merge(0, 1, (integer1, integer2) -> integer1 - integer2);
            } else {
                map.merge(i, 1, (integer1, integer2) -> integer1 - integer2);
            }
        }

        return true;
    }
}
