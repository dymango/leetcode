package leetcodepractice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author dimmy
 */
public class FindRestaurant_599 {

    /**
     * 假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
     *
     * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。
     *
     * 示例 1:
     *
     * 输入:
     * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
     * ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
     * 输出: ["Shogun"]
     * 解释: 他们唯一共同喜爱的餐厅是“Shogun”。
     * 示例 2:
     *
     * 输入:
     * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
     * ["KFC", "Shogun", "Burger King"]
     * 输出: ["Shogun"]
     * 解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
     * 提示:
     *
     * 两个列表的长度范围都在 [1, 1000]内。
     * 两个列表中的字符串的长度将在[1，30]的范围内。
     * 下标从0开始，到列表的长度减1。
     * 两个列表都没有重复的元素。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param list1
     * @param list2
     * @return
     *
     * ["Shogun","Tapioca Express","Burger King","KFC"]
     * ["KFC","Shogun","Burger King"]
     * 输出：
     * ["KFC","Shogun","Burger King"]
     * 预期结果：
     * ["Shogun"]
     */
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        int indexSum = Integer.MAX_VALUE;
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < list2.length; i++) {
            if(map.containsKey(list2[i])) {
                int n = map.get(list2[i]) + i;
                if(n < indexSum) {
                    stringList.clear();
                    stringList.add(list2[i]);
                    indexSum = n;
                } else if(n == indexSum){
                    stringList.add(list2[i]);
                }
            }
        }

        return stringList.toArray(new String[stringList.size()]);
    }
}
