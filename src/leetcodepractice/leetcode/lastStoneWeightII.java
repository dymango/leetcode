package leetcodepractice.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dimmy
 */
public class lastStoneWeightII {

    /**
     * 有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。
     * <p>
     * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
     * <p>
     * 如果 x == y，那么两块石头都会被完全粉碎；
     * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
     * 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
     * <p>
     * <p>
     * 最后两块石头必须尽量地重且重量相近
     * <p>
     * 2 7 4 1 8 1
     * 111
     * <p>
     * 9   26
     * 12
     * <p>
     * 9
     * 7
     * 21
     * <p>
     * 9 26 31 33
     * 24 26 31
     * [31,26,33,21,40]
     * 5 7 12 9
     * 31 24
     * 9 26 21 33
     * 7 12
     * 7 19 31
     * 24
     * <p>
     * 1,1,2,3,5,8,13,21,34,55,89,14,23,37,61,98
     *
     * [21,60,61,20,31]
     * 5
     *      * 2
     *
     *
     *
     * 20 21 31 60 61
     * 20 30 39
     * 10
     *
     * 41
     * 39 31
     *
     *
     * @param stones
     * @return
     */
    public int lastStoneWeightII(int[] stones) {
        List<Integer> stoneList = Arrays.stream(stones).boxed().sorted().collect(Collectors.toList());
        while (stoneList.size() > 2) {
            if(stoneList.size() > 3) {
                var last = stoneList.getLast();
                var smallerOne = stoneList.get(stoneList.size() - 3);
                stoneList.remove(stoneList.size() - 3);
                stoneList.removeLast();
                if (last > smallerOne) {
                    var r = last - smallerOne;
                    stoneList.add(r);
                }
            } else {
                var last = stoneList.getLast();
                stoneList.removeLast();
                var smallerOne = stoneList.getLast();
                stoneList.removeLast();
                if (last > smallerOne) {
                    var r = last - smallerOne;
                    stoneList.add(r);
                }
            }

            stoneList.sort(Integer::compareTo);
        }

        if (stoneList.isEmpty()) return 0;
        if (stoneList.size() == 1) return stoneList.getFirst();

        return stoneList.getLast() - stoneList.getFirst();
    }

    public static void main(String[] args) {
        new lastStoneWeightII().lastStoneWeightII(new int[]{21,60,61,20,31});
//        new lastStoneWeightII().lastStoneWeightII(new int[]{1,1,2,3,5,8,13,21,34,55,89,14,23,37,61,98});
    }
}
