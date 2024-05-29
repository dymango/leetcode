package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class MaxDistToClosest {

    /**
     * 给你一个数组 seats 表示一排座位，其中 seats[i] = 1 代表有人坐在第 i 个座位上，seats[i] = 0 代表座位 i 上是空的（下标从 0 开始）。
     * <p>
     * 至少有一个空座位，且至少有一人已经坐在座位上。
     * <p>
     * 亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上。
     * <p>
     * 返回他到离他最近的人的最大距离。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：seats = [1,0,0,0,1,0,1]
     * 输出：2
     * 解释：
     * 如果亚历克斯坐在第二个空位（seats[2]）上，他到离他最近的人的距离为 2 。
     * 如果亚历克斯坐在其它任何一个空位上，他到离他最近的人的距离为 1 。
     * 因此，他到离他最近的人的最大距离是 2 。
     * 示例 2：
     * <p>
     * 输入：seats = [1,0,0,0]
     * 输出：3
     * 解释：
     * 如果亚历克斯坐在最后一个座位上，他离最近的人有 3 个座位远。
     * 这是可能的最大距离，所以答案是 3 。
     * 示例 3：
     * <p>
     * 输入：seats = [0,1]
     * 输出：1
     *  
     * <p>
     * 提示：
     * <p>
     * 2 <= seats.length <= 2 * 104
     * seats[i] 为 0 或 1
     * 至少有一个 空座位
     * 至少有一个 座位上有人
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximize-distance-to-closest-person
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param seats
     * @return
     */
    public int maxDistToClosest(int[] seats) {
        int[] fromLeft = new int[seats.length];
        boolean signLeft = false;
        int startPosition = 0;
        for (int i = 0; i < fromLeft.length; i++) {
            if (seats[i] == 1) {
                if(!signLeft) startPosition = i;
                signLeft = true;
                continue;
            }

            if (!signLeft) continue;
            if (seats[i - 1] == 1) {
                fromLeft[i] = 1;
                continue;
            }

            fromLeft[i] = fromLeft[i - 1] + 1;
        }

        int max = Integer.MIN_VALUE;
        int right = 0;
        boolean sign = false;
        for (int i = seats.length - 1; i >= 0; i--) {
            if (seats[i] == 1) {
                sign = true;
                right = 0;
                continue;
            }

            if (!sign) {
                max = Math.max(max, fromLeft[i]);
                continue;
            }
            right = right + 1;
            if(signLeft) {
                if(i > startPosition) max = Math.max(max, Math.min(right, fromLeft[i]));
                else  max = Math.max(max, right);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        MaxDistToClosest m = new MaxDistToClosest();
        System.out.println(m.maxDistToClosest(new int[]{1, 0, 0, 0, 1, 0, 1}));
        System.out.println(m.maxDistToClosest(new int[]{1, 0, 0}));
        System.out.println(m.maxDistToClosest(new int[]{0, 1}));
    }
}
