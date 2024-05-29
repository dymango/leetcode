package leetcodepractice.leetcode;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @author dimmy
 */
public class SumSubarrayMins_907 {

    /**
     * 给定一个整数数组 arr，找到 min(b) 的总和，其中 b 的范围为 arr 的每个（连续）子数组。
     * 由于答案可能很大，因此 返回答案模 10^9 + 7 。
     * <p>
     * 示例 1：
     * 输入：arr = [3,1,2,4]
     * 输出：17
     * 解释：
     * 子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。
     * 最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。
     * <p>
     * 示例 2：
     * 输入：arr = [11,81,94,43,3]
     * 输出：444
     * <p>
     * 提示：
     * 1 <= arr.length <= 3 * 104
     * 1 <= arr[i] <= 3 * 104
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/sum-of-subarray-minimums
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param arr
     * @return
     */
    public int sumSubarrayMins(int[] arr) {
        int sum = 0;
        for (int i = 1; i <= arr.length; i++) {
            int elements = 0;
            int start = 0;
            PriorityQueue<Integer> nums = new PriorityQueue<>();
            for (int j = 0; j < arr.length; j++) {
                if (elements < i) {
                    nums.offer(arr[j]);
                    elements++;

                    if (elements == i) {
                        sum += nums.peek();
                        sum %= 1000000007;
                        nums.remove(arr[start++]);
                        elements--;
                    }
                }
            }
        }

        return sum;
    }

    public static class Node {
        public int num;
        public int index;

        public Node(int num, int index) {
            this.num = num;
            this.index = index;
        }
    }

    public int sumSubarrayMinsV2(int[] arr) {
        long sum = 0;
        Stack<Integer> indexStack = new Stack<>();
        for (int i = 0; i <= arr.length; i++) {
            int n = i == arr.length ? 0 : arr[i];
            if (indexStack.isEmpty()) {
                indexStack.push(i);
                continue;
            }

            while (!indexStack.isEmpty() && arr[indexStack.peek()] > n) {
                Integer ti = indexStack.pop();
                int left = indexStack.isEmpty() ? -1 : indexStack.peek();
                sum += (long) (ti - left) * (i - ti) * arr[ti];
                sum %= 1000000007;
            }

            indexStack.push(i);
        }

        return (int) sum;
    }

    public int sumSubarrayMinsV3(int[] arr) {
        long result = 0;
        int[] stack = new int[arr.length]; // 使用数组结构模拟堆栈，里面存储arr数组的下标，为了便于计算“管辖区域”的跨度
        int head = 0, tail = head, mod = (int) (1e9 + 7); // 配合模拟堆栈的head指针和tail指针
        for (int i = 0; i <= arr.length; i++) {
            int num = (i == arr.length) ? 0 : arr[i]; // 如果arr数组遍历到最后一个元素，则还需要模拟结尾元素0，为了让stack中元素都出栈
            while (head != tail && arr[stack[tail - 1]] > num) {
                int n = stack[--tail]; // 待计算数字arr[n]的【数组下标】
                int h = (head != tail) ? stack[tail - 1] : -1; // arr[n]的“辐射区域”head头的【数组下标】（开区间）
                int t = i; // arr[n]的“辐射区域”tail尾的【数组下标】（开区间）
                result = (result + (long) (n - h) * (t - n) * arr[n]) % mod;
            }
            stack[tail++] = i;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(new SumSubarrayMins_907().sumSubarrayMinsV2(new int[]{71, 55, 82, 55}));
    }
}
