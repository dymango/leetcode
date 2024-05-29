package leetcodepractice.leetcode;

import java.util.Arrays;

/**
 * @author dimmy
 */
public class NumFriendRequests_825 {

    /**
     * 人们会互相发送好友请求，现在给定一个包含有他们年龄的数组，ages[i] 表示第 i 个人的年龄。
     * 当满足以下任一条件时，A 不能给 B（A、B不为同一人）发送好友请求：
     * <p>
     * age[B] <= 0.5 * age[A] + 7
     * age[B] > age[A]
     * age[B] > 100 && age[A] < 100
     * 否则，A 可以给 B 发送好友请求。
     * <p>
     * 注意如果 A 向 B 发出了请求，不等于 B 也一定会向 A 发出请求。而且，人们不会给自己发送好友请求。 
     * <p>
     * 求总共会发出多少份好友请求?
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：[16,16]
     * 输出：2
     * 解释：二人可以互发好友申请。
     * 示例 2：
     * <p>
     * 输入：[16,17,18]
     * 输出：2
     * 解释：好友请求可产生于 17 -> 16, 18 -> 17.
     * 示例 3：
     * <p>
     * 输入：[20,30,100,110,120]
     * 输出：3
     * 解释：好友请求可产生于 110 -> 100, 120 -> 110, 120 -> 100.
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= ages.length <= 20000
     * 1 <= ages[i] <= 120
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/friends-of-appropriate-ages
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param ages
     * @return
     */
    public static int numFriendRequests(int[] ages) {
        double[] dages = new double[ages.length];
        for (int i = 0; i < ages.length; i++) {
            dages[i] = ages[i];
        }
        Arrays.sort(dages);
        int count = 0;
        for (int i = 0; i < dages.length; i++) {
            int leftPointer = i - 1;
            while (leftPointer >= 0) {
                if(dages[i] * 0.5 + 7 >= dages[leftPointer]) break;
                if(dages[i] < dages[leftPointer]) break;
                count++;
                leftPointer--;
            }

            int rightPointer = i + 1;
            while (rightPointer < ages.length) {
                if(dages[i] * 0.5 + 7 >= dages[rightPointer]) break;
                if(dages[i] < dages[rightPointer]) break;
                count++;
                rightPointer++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(numFriendRequests(new int[]{16, 17, 18}));
        System.out.println(numFriendRequests(new int[]{20, 30, 100, 110, 120}));
        System.out.println(numFriendRequests(new int[]{73, 106, 39, 6, 26, 15, 30, 100, 71, 35, 46, 112, 6, 60, 110}));
    }
}
