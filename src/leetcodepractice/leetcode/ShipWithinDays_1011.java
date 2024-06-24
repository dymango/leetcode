package leetcodepractice.leetcode;

import leetcodepractice.executor.MainMethod;
import leetcodepractice.executor.MainParam;

import java.util.Arrays;

/**
 * @author dimmy
 */
public class ShipWithinDays_1011 {

    /**
     * 传送带上的包裹必须在 days 天内从一个港口运送到另一个港口。
     * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量（weights）的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
     * 返回能在 days 天内将传送带上的所有包裹送达的船的最低运载能力。
     * <p>
     * 分析： 定义为规划问题，第n天要传送前f个包裹，船的最大装载重量为max
     * 定义数组[n][f] = max
     * <p>
     * <p>
     * 示例 1：
     * 输入：weights = [1,2,3,4,5,6,7,8,9,10], days = 5
     * 输出：15
     * 解释：
     * 船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
     * 第 1 天：1, 2, 3, 4, 5
     * 第 2 天：6, 7
     * 第 3 天：8
     * 第 4 天：9
     * 第 5 天：10
     * <p>
     * 请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。
     * 示例 2：
     * <p>
     * 输入：weights = [3,2,2,4,1,4], days = 3
     * 输出：6
     * 解释：
     * 船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
     * 第 1 天：3, 2
     * 第 2 天：2, 4
     * 第 3 天：1, 4
     * 示例 3：
     * <p>
     * 输入：weights = [1,2,3,1,1], days = 4
     * 输出：3
     * 解释：
     * 第 1 天：1
     * 第 2 天：2
     * 第 3 天：3
     * 第 4 天：1, 1
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= days <= weights.length <= 5 * 104
     * 1 <= weights[i] <= 500
     *
     * @param weights
     * @param days
     * @return 假设当船的运载能力为 xxx 时，我们可以在 days\textit{days}days 天内运送完所有包裹，那么只要运载能力大于 xxx，我们同样可以在 days\textit{days}days 天内运送完所有包裹：我们只需要使用运载能力为 xxx 时的运送方法即可。
     * <p>
     * 这样一来，我们就得到了一个非常重要的结论：
     * <p>
     * 存在一个运载能力的「下限」xansx_\textit{ans}x
     * ans
     * ​
     * ，使得当 x≥xansx \geq x_\textit{ans}x≥x
     * ans
     * ​
     * 时，我们可以在 days\textit{days}days 天内运送完所有包裹；当 x<xansx < x_\textit{ans}x<x
     * ans
     * ​
     * 时，我们无法在 days\textit{days}days 天内运送完所有包裹。
     * <p>
     * 同时，xansx_\textit{ans}x
     * ans
     * ​
     * 即为我们需要求出的答案。因此，我们就可以使用二分查找的方法找出 xansx_\textit{ans}x
     * ans
     * ​
     * 的值。
     * <p>
     * 在二分查找的每一步中，我们实际上需要解决一个判定问题：给定船的运载能力 xxx，我们是否可以在 days\textit{days}days 天内运送完所有包裹呢？这个判定问题可以通过贪心的方法来解决：
     * <p>
     * 由于我们必须按照数组 weights\textit{weights}weights 中包裹的顺序进行运送，因此我们从数组 weights\textit{weights}weights 的首元素开始遍历，将连续的包裹都安排在同一天进行运送。当这批包裹的重量大于运载能力 xxx 时，我们就需要将最后一个包裹拿出来，安排在新的一天，并继续往下遍历。当我们遍历完整个数组后，就得到了最少需要运送的天数。
     * <p>
     * 我们将「最少需要运送的天数」与 days\textit{days}days 进行比较，就可以解决这个判定问题。当其小于等于 days\textit{days}days 时，我们就忽略二分的右半部分区间；当其大于 days\textit{days}days 时，我们就忽略二分的左半部分区间。
     * <p>
     * 细节
     * <p>
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/capacity-to-ship-packages-within-d-days/solutions/743995/zai-d-tian-nei-song-da-bao-guo-de-neng-l-ntml/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    @MainParam
    int[] weights = {70, 259, 379, 369, 287, 145, 259, 29, 150, 410, 493, 121, 184, 92, 79, 168, 269, 209, 139, 437} ;
    @MainParam
    int days = 20;

    //10 10 80 10 90
    // 80
    @MainMethod
    public int shipWithinDays(int[] weights, int days) {
        // 确定二分查找左右边界
        int left = Arrays.stream(weights).max().getAsInt(), right = Arrays.stream(weights).sum();
        while (left < right) {
            int mid = (left + right) / 2;
            // need 为需要运送的天数
            // cur 为当前这一天已经运送的包裹重量之和
            int need = 1, cur = 0;
            for (int weight : weights) {
                if (cur + weight > mid) {
                    ++need;
                    cur = 0;
                }
                cur += weight;
            }
            if (need <= days) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

