package app.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author dimmy
 */
public class MinMutation_433 {

    /**
     * 一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。
     *
     * 假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。
     *
     * 例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。
     *
     * 与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。
     *
     * 现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变化次数。如果无法实现目标变化，请返回 -1。
     *
     * 注意:
     *
     * 起始基因序列默认是合法的，但是它并不一定会出现在基因库中。
     * 所有的目标基因序列必须是合法的。
     * 假定起始基因序列与目标基因序列是不一样的。
     * 示例 1:
     *
     * start: "AACCGGTT"
     * end:   "AACCGGTA"
     * bank: ["AACCGGTA"]
     *
     * 返回值: 1
     * 示例 2:
     *
     * start: "AACCGGTT"
     * end:   "AAACGGTA"
     * bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
     *
     * 返回值: 2
     * 示例 3:
     *
     * start: "AAAAACCC"
     * end:   "AACCCCCC"
     * bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
     *
     * 返回值: 3
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-genetic-mutation
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param start
     * @param end
     * @param bank
     * @return
     */
    public static int minMutation(String start, String end, String[] bank) {
        boolean[] marked = new boolean[bank.length];
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        int count = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                for (int k = 0; k < poll.length(); k++) {
                    for (int j = 0; j < bank.length; j++) {
                        int difc = 0;
                        for (int l = 0; l < poll.length(); l++) {
                            if(poll.charAt(l) != bank[j].charAt(l)) difc++;
                        }

                        if(difc == 1 && !marked[j]) {
                            if(bank[j].equals(end)) return count;
                            queue.add(bank[j]);
                            marked[j] = true;
                        }
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
//        minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"});
        System.out.println(minMutation("AAAAACCC", "AACCCCCC", new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC"}));
        System.out.println(minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGATT","AACCGATA","AAACGATA","AAACGGTA"}));
    }
}
