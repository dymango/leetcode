package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class ThreeEqualParts_927 {

    /**
     * 给定一个由 0 和 1 组成的数组 arr ，将数组分成  3 个非空的部分 ，使得所有这些部分表示相同的二进制值。
     * 如果可以做到，请返回任何 [i, j]，其中 i+1 < j，这样一来：
     * <p>
     * arr[0], arr[1], ..., arr[i] 为第一部分；
     * arr[i + 1], arr[i + 2], ..., arr[j - 1] 为第二部分；
     * arr[j], arr[j + 1], ..., arr[arr.length - 1] 为第三部分。
     * 这三个部分所表示的二进制值相等。
     * 如果无法做到，就返回 [-1, -1]。
     * <p>
     * 注意，在考虑每个部分所表示的二进制时，应当将其看作一个整体。例如，[1,1,0] 表示十进制中的 6，而不会是 3。此外，前导零也是被允许的，所以 [0,1,1] 和 [1,1] 表示相同的值。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：arr = [1,0,1,0,1]
     * 输出：[0,3]
     * 示例 2：
     * <p>
     * 输入：arr = [1,1,0,1,1]
     * 输出：[-1,-1]
     * 示例 3:
     * <p>
     * 输入：arr = [1,1,0,0,1]
     * 输出：[0,2]
     *  
     * <p>
     * 提示：
     * <p>
     * 3 <= arr.length <= 3 * 104
     * arr[i] 是 0 或 1
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/three-equal-parts
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * <p>
     * <p>
     * 方法一：将 11 的数量三等分
     * 思路与算法
     * <p>
     * 如果存在一种分法使得三个非空部分所表示的二进制值相同，那么最终每一部分 11 的数量一定是相等的。根据这个思想，我们首先统计数组 \textit{arr}arr 中 11 的个数，把它设为 \textit{sum}sum。如果 \textit{sum}sum 不能被 33 整除，那么显然不存在正确分法。否则，每一个部分都应当有 \textit{partial} = \dfrac{\textit{sum}}{3}partial=
     * 3
     * sum
     * ​
     * 个 11。
     * <p>
     * 我们尝试找到 \textit{arr}arr 中第 11 个 11 出现的位置 \textit{first}first，第 \textit{partial} + 1partial+1 个 11 出现的位置 \textit{second}second 以及第 2 \times \textit{partial} + 12×partial+1 个 11 出现的位置 \textit{third}third。因为每一部分末尾的 00 可以移动到下一部分的首部从而改变二进制值的大小, 所以每一部分的末尾难以界定。但是注意到，数组的末尾是无法改变的，因此区间 [\textit{third}, \textit{arr.length} - 1][third,arr.length−1] 所表示的二进制值可以固定。
     * <p>
     * 设 \textit{len} = \textit{arr.length} - \textit{third}len=arr.length−third，表示二进制值的长度。接下来只需要判断 [\textit{first}, \textit{first} + \textit{len})[first,first+len)、[\textit{second}, \textit{second} + \textit{len})[second,second+len) 和 [\textit{third}, \textit{third} + \textit{len})[third,third+len) 是否完全相同即可。前提是 \textit{first} + \textit{len} \le \textit{second}first+len≤second 并且 \textit{second} + \textit{len} \le \textit{third}second+len≤third。
     * <p>
     * 如果以上三段区间是完全相同的，那么答案就是 [\textit{first} + \textit{len} - 1, \textit{second} + \textit{len}][first+len−1,second+len]。最后需要注意到，如果 \textit{sum} = 0sum=0，我们需要直接返回答案 [0, 2][0,2]（或者其他任意合法答案）。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode.cn/problems/three-equal-parts/solution/san-deng-fen-by-leetcode-solution-3l2y/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * <p>
     * <p>
     * 根据题目描述，我们可以知道要将arr数组分成3份，并且对于这3份由0和1组成的二进制值要相同。因为是二进制，由0和1组成，所以，如果二进制相同的话，那么这3个分组中，1的个数一定是相同的。所以，以下图为例，我们统计出了一共有3个“1”，满足被3整除。所以，第一个条件就满足了。
     * <p>
     * “1”我们校验完毕之后，我们再来看看“0”。对于二进制来说，影响最终结果的其实是**“1”后面的“0”的个数**，（即：00010和00000010是相等的，但是0010和001000就是不等的了）。那么我们可以推导出在arr数组中最后的那个“1”，它后面有多少个“0”，那么每个分组中的最后那个“1”后面就必须有相同数量的“0”。我们还是以下图为例，由于arr[7]是最后一个“1”，它后面只有1个“0”，那么根据上面我们描述的规律，就可以将数组 arr = [0,0,1,0,1,0,0,1,0] 拆分为[0,0,1,0]、[1,0]和[0,1,0]。
     * <p>
     * 然后，我们以最短分组长度为基准，从末尾开始校验每组中相对应位置的值是否相同，如果都相同，那么就满足了题目中所描述的“三等分”了。然后将[i, j]返回即可。
     * <p>
     * 作者：muse-77
     * 链接：https://leetcode.cn/problems/three-equal-parts/solution/-by-muse-77-dper/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param arr
     * @return
     */
    public static void main(String[] args) {
        //[0,1,0,1,1,0,1,1,0,1]
        //[1,1,1,0,1,0,0,1,0,1,0,0,0,1,0,0,
        // 1,1,1,0,1,0,0,1,0,1,0,0,0,1,0,0,0,
        // 0,1,1,1,0,1,0,0,1,0,1,0,0,0,1,0,0]
        //15  32

        for (int i : new ThreeEqualParts_927().threeEqualParts(new int[]{1,0,1,0,1})) {
            System.out.println(i);
        }
    }

    public int[] threeEqualParts(int[] arr) {
        int length = arr.length;
        int[] continuousZeroCount = new int[length];
        int[] continuousOneCount = new int[length];
        int[] oneSum = new int[length];
        continuousZeroCount[0] = arr[0] == 0 ? 1 : 0;
        continuousOneCount[0] = arr[0] == 1 ? 1 : 0;
        oneSum[0] = arr[0] == 1 ? 1 : 0;
        for (int i = 1; i < length; i++) {
            if (arr[i] == 0) continuousZeroCount[i] = continuousZeroCount[i - 1] + 1;
            if (arr[i] == 1) continuousOneCount[i] = continuousOneCount[i - 1] + 1;
            oneSum[i] = arr[i] == 1 ? oneSum[i - 1] + 1 : oneSum[i - 1];
            oneSum[i] = oneSum[i - 1] + (arr[i] == 1 ? 1 : 0);
        }

        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j > i + 1; j--) {
                int aStart = 0;
                int aEnd = i;
                int bStart = i + 1;
                int bEnd = j - 1;
                int cStart = j;
                int cEnd = length - 1;
                if (oneSum[aEnd] != oneSum[bEnd] - oneSum[bStart - 1] || oneSum[aEnd] != oneSum[cEnd] - oneSum[cStart - 1]) continue;
                while (arr[aEnd] == arr[bEnd] && arr[aEnd] == arr[cEnd]) {
                    if (arr[aEnd] == 1) {
                        int aCount = Math.min(continuousOneCount[aEnd], aEnd - aStart + 1);
                        int bCount = Math.min(continuousOneCount[bEnd], bEnd - bStart + 1);
                        int cCount = Math.min(continuousOneCount[cEnd], cEnd - cStart + 1);
                        if (aCount != bCount || aCount != cCount) break;
                        aEnd -= aCount;
                        bEnd -= bCount;
                        cEnd -= cCount;

                        //如果某一个区间超出了，检查其他区间是否都只剩0
                        if (aEnd < aStart) {
                            if (isRequired(continuousZeroCount, bEnd, bStart) && isRequired(continuousZeroCount, cEnd, cStart)) return new int[]{i, j};
                            else break;
                        }
                        if (bEnd < bStart) {
                            if (isRequired(continuousZeroCount, aEnd, aStart) && isRequired(continuousZeroCount, cEnd, cStart)) return new int[]{i, j};
                            else break;
                        }

                        if (cEnd < cStart) {
                            if (isRequired(continuousZeroCount, bEnd, bStart) && isRequired(continuousZeroCount, aEnd, aStart)) return new int[]{i, j};
                            else break;
                        }

                    } else {
                        int aCount = Math.min(continuousZeroCount[aEnd], aEnd - aStart + 1);
                        int bCount = Math.min(continuousZeroCount[bEnd], bEnd - bStart + 1);
                        int cCount = Math.min(continuousZeroCount[cEnd], cEnd - cStart + 1);
                        if ((aCount != bCount || aCount != cCount) && (aCount + aStart - 1 < aEnd && bCount + bStart - 1 < bEnd && cCount + cStart - 1 < cEnd)) break;
                        aEnd -= aCount;
                        bEnd -= bCount;
                        cEnd -= cCount;
                        if (aEnd < aStart) {
                            if (isRequired(continuousZeroCount, bEnd, bStart) && isRequired(continuousZeroCount, cEnd, cStart)) return new int[]{i, j};
                            else break;
                        }
                        if (bEnd < bStart) {
                            if (isRequired(continuousZeroCount, aEnd, aStart) && isRequired(continuousZeroCount, cEnd, cStart)) return new int[]{i, j};
                            else break;
                        }

                        if (cEnd < cStart) {
                            if (isRequired(continuousZeroCount, bEnd, bStart) && isRequired(continuousZeroCount, aEnd, aStart)) return new int[]{i, j};
                            else break;
                        }

                    }
                }
            }
        }

        return new int[]{-1, -1};
    }

    private boolean isRequired(int[] count, int current, int start) {
        if (current < start) return true;
        if (count[current] == 0) return false;
        return current - start + 1 <= count[current];
    }
}
