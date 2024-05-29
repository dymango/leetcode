package leetcodepractice.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dimmy
 */
public class FindClosestElements_658 {

    /**
     * 给定一个排序好的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
     *
     * 整数 a 比整数 b 更接近 x 需要满足：
     *
     * |a - x| < |b - x| 或者
     * |a - x| == |b - x| 且 a < b
     *  
     *
     * 示例 1：
     *
     * 输入：arr = [1,2,3,4,5], k = 4, x = 3
     * 输出：[1,2,3,4]
     * 示例 2：
     *
     * 输入：arr = [1,2,3,4,5], k = 4, x = -1
     * 输出：[1,2,3,4]
     *  
     *
     * 提示：
     *
     * 1 <= k <= arr.length
     * 1 <= arr.length <= 104
     * 数组里的每个元素与 x 的绝对值不超过 104
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-k-closest-elements
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param arr
     * @param k
     * @param x
     * @return
     *
     * [0,1,1,1,2,3,6,7,8,9] 9 4
     */
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) +1);
        }

        List<Integer> numList = new ArrayList<>();
        if(map.containsKey(x)) {
            Integer integer = map.get(x);
            for (int i = 0; i < integer; i++) {
                numList.add(x);
                k--;
            }

        }

        int dif = 1;
        while(k != 0) {
            if(map.containsKey(x - dif)) {
                  Integer integer = map.get(x - dif);
                  for (int i = 0; i < integer; i++) {
                      if(k > 0) {
                          numList.add(x - dif);
                          k--;
                      }

                  }
            }

            if(map.containsKey(x + dif)) {
                    Integer integer = map.get(x + dif);
                    for (int i = 0; i < integer; i++) {
                        if(k > 0) {
                            numList.add(x + dif);
                            k--;
                        }
                    }
            }

            dif++;
        }

        Collections.sort(numList);
        return numList;
    }

    public static void main(String[] args) {
        findClosestElements(new int[]{0,1,1,1,2,3,6,7,8,9}, 9, 4);
    }
}
