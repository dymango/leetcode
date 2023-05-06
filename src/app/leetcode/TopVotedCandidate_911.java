package app.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dimmy
 */
public class TopVotedCandidate_911 {

    /**
     * 给你两个整数数组 persons 和 times 。在选举中，第 i 张票是在时刻为 times[i] 时投给候选人 persons[i] 的。
     * <p>
     * 对于发生在时刻 t 的每个查询，需要找出在 t 时刻在选举中领先的候选人的编号。
     * <p>
     * 在 t 时刻投出的选票也将被计入我们的查询之中。在平局的情况下，最近获得投票的候选人将会获胜。
     * <p>
     * 实现 TopVotedCandidate 类：
     * <p>
     * TopVotedCandidate(int[] persons, int[] times) 使用 persons 和 times 数组初始化对象。
     * int q(int t) 根据前面描述的规则，返回在时刻 t 在选举中领先的候选人的编号。
     *  
     * 示例：
     * <p>
     * 输入：
     * ["TopVotedCandidate", "q", "q", "q", "q", "q", "q"]
     * [[[0, 1, 1, 0, 0, 1, 0], [0, 5, 10, 15, 20, 25, 30]], [3], [12], [25], [15], [24], [8]]
     * <p>
     * 3 8 12 15 24 25 30
     * 10
     * 输出：
     * [null, 0, 1, 1, 0, 0, 1]
     * <p>
     * 解释：
     * TopVotedCandidate topVotedCandidate = new TopVotedCandidate([0, 1, 1, 0, 0, 1, 0], [0, 5, 10, 15, 20, 25, 30]);
     * topVotedCandidate.q(3); // 返回 0 ，在时刻 3 ，票数分布为 [0] ，编号为 0 的候选人领先。
     * topVotedCandidate.q(12); // 返回 1 ，在时刻 12 ，票数分布为 [0,1,1] ，编号为 1 的候选人领先。
     * topVotedCandidate.q(25); // 返回 1 ，在时刻 25 ，票数分布为 [0,1,1,0,0,1] ，编号为 1 的候选人领先。（在平局的情况下，1 是最近获得投票的候选人）。
     * topVotedCandidate.q(15); // 返回 0
     * topVotedCandidate.q(24); // 返回 0
     * topVotedCandidate.q(8); // 返回 1
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= persons.length <= 5000
     * times.length == persons.length
     * 0 <= persons[i] < persons.length
     * 0 <= times[i] <= 109
     * times 是一个严格递增的有序数组
     * times[0] <= t <= 109
     * 每个测试用例最多调用 104 次 q
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/online-election
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param persons
     * @param times
     */
    private final int[] times;
    private final int[] maxVotes;

    public TopVotedCandidate_911(int[] persons, int[] times) {
        this.times = times;
        int size = times.length;
        int max = 0;
        int candidate = 0;
        maxVotes = new int[size];
        Map<Integer, Integer> tickets = new HashMap<>();
        for (int i = 0; i < size; i++) {
            Integer person = persons[i];
            Integer merge = tickets.merge(person, 1, Integer::sum);
            if (merge >= max) {
                max = merge;
                candidate = person;
            }

            maxVotes[i] = candidate;
        }
    }

    public int q(int t) {
        int size = times.length;
        int start = 0;
        int end = size - 1;
        int index = 0;
        while (start < end) {
            int middle = start + (end - start) / 2;
            if (times[middle] > t) {
                end = middle - 1;
            } else if (times[middle] < t) {
                start = middle + 1;
            } else {
                index = middle;
                break;
            }

            if (start >= end) {
                if (times[start] <= t) index = start;
                else index = start - 1;
                break;
            }
        }

        return maxVotes[index];
    }

    public static void main(String[] args) {
        //["TopVotedCandidate","q","q","q","q","q","q","q","q","q","q"]
        //[[[0,1,2,2,1],[20,28,29,54,56]],[28],[53],[57],[29],[29],[28],[30],[20],[56],[55]]
        TopVotedCandidate_911 topVotedCandidate_911 = new TopVotedCandidate_911(new int[]{0, 1, 2, 2, 1}, new int[]{20, 28, 29, 54, 56});
        System.out.println(topVotedCandidate_911.q(53));

    }
}
