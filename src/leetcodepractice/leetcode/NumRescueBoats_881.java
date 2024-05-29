package leetcodepractice.leetcode;

import java.util.Arrays;

/**
 * @author dimmy
 */
public class NumRescueBoats_881 {

    /**
     * 给定数组 people 。people[i]表示第 i 个人的体重 ，船的数量不限，每艘船可以承载的最大重量为 limit。
     * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
     * 返回 承载所有人所需的最小船数 。
     * <p>
     * 示例 1：
     * 输入：people = [1,2], limit = 3
     * 输出：1
     * 解释：1 艘船载 (1, 2)
     * <p>
     * 示例 2：
     * 输入：people = [3,2,2,1], limit = 3
     * 输出：3
     * 解释：3 艘船分别载 (1, 2), (2) 和 (3)
     * <p>
     * 示例 3：
     * 输入：people = [3,5,3,4], limit = 5
     * 输出：4
     * 解释：4 艘船分别载 (3), (3), (4), (5)
     * <p>
     * 提示：
     * 1 <= people.length <= 5 * 104
     * 1 <= people[i] <= limit <= 3 * 104
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/boats-to-save-people
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param people
     * @param limit
     * @return
     */
    public int numRescueBoats(int[] people, int limit) {
        int length = people.length;
        int count = length % 2 == 0 ? length / 2 : (length / 2 + 1);
        int sign = length - count;
        Arrays.sort(people);
        boolean[] visited = new boolean[length];
        for (int i = 0; i < sign; i++) {
            if (visited[i]) continue;
            int start = length - 1;
            if (people[sign] + people[i] > limit) start = sign - 1;
            boolean match = false;
            while (start >= 0) {
                if (!visited[start] && people[i] + people[start] <= limit) {
                    visited[start] = true;
                    match = true;
                    break;
                }

                start--;
            }

            if (!match || start < sign) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new NumRescueBoats_881().numRescueBoats(new int[]{3, 5, 3, 5}, 5));
        System.out.println(new NumRescueBoats_881().numRescueBoats(new int[]{3, 2, 2, 1}, 3));
        System.out.println(new NumRescueBoats_881().numRescueBoats(new int[]{1, 2}, 3));
        System.out.println(new NumRescueBoats_881().numRescueBoats(new int[]{3, 4, 3}, 5));
        System.out.println(new NumRescueBoats_881().numRescueBoats(new int[]{6, 3, 5, 6, 2, 3}, 6));
    }
}
