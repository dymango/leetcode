package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class NextPermutation_31 {


    /**
     * 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
     * <p>
     * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
     * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
     * <p>
     * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
     * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
     * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
     * 给你一个整数数组 nums ，找出 nums 的下一个排列。
     * <p>
     * 必须 原地 修改，只允许使用额外常数空间。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,3]
     * 输出：[1,3,2]
     * 示例 2：
     * <p>
     * 输入：nums = [3,2,1]
     * 输出：[1,2,3]
     * 示例 3：
     * <p>
     * 输入：nums = [1,1,5]
     * 输出：[1,5,1]
     *  
     * <p>
     * <p>
     * 如何得到这样的排列顺序？这是本文的重点。我们可以这样来分析：
     * <p>
     * 我们希望下一个数 比当前数大，这样才满足 “下一个排列” 的定义。因此只需要 将后面的「大数」与前面的「小数」交换，就能得到一个更大的数。比如 123456，将 5 和 6 交换就能得到一个更大的数 123465。
     * 我们还希望下一个数 增加的幅度尽可能的小，这样才满足“下一个排列与当前排列紧邻“的要求。为了满足这个要求，我们需要：
     * 在 尽可能靠右的低位 进行交换，需要 从后向前 查找
     * 将一个 尽可能小的「大数」 与前面的「小数」交换。比如 123465，下一个排列应该把 5 和 4 交换而不是把 6 和 4 交换
     * 将「大数」换到前面后，需要将「大数」后面的所有数 重置为升序，升序排列就是最小的排列。以 123465 为例：首先按照上一步，交换 5 和 4，得到 123564；然后需要将 5 之后的数重置为升序，得到 123546。显然 123546 比 123564 更小，123546 就是 123465 的下一个排列
     * 以上就是求 “下一个排列” 的分析过程。
     * <p>
     * 算法过程
     * 标准的 “下一个排列” 算法可以描述为：
     * <p>
     * 从后向前 查找第一个 相邻升序 的元素对 (i,j)，满足 A[i] < A[j]。此时 [j,end) 必然是降序
     * 在 [j,end) 从后向前 查找第一个满足 A[i] < A[k] 的 k。A[i]、A[k] 分别就是上文所说的「小数」、「大数」
     * 将 A[i] 与 A[k] 交换
     * 可以断定这时 [j,end) 必然是降序，逆置 [j,end)，使其升序
     * 如果在步骤 1 找不到符合的相邻元素对，说明当前 [begin,end) 为一个降序顺序，则直接跳到步骤 4
     * 该方法支持数据重复，且在 C++ STL 中被采用。
     * <p>
     * <p>
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/next-permutation
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     */
    public static void main(String[] args) {
        new NextPermutation_31().nextPermutation(new int[]{1, 2, 3});
        new NextPermutation_31().nextPermutation(new int[]{1, 3, 2});
    }

    public void nextPermutation(int[] nums) {
        int length = nums.length;
        boolean find = false;
        for (int i = length - 1; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) {
                for (int j = length - 1; j >= i; j--) {
                    if (nums[j] > nums[i - 1]) {
                        int t = nums[j];
                        nums[j] = nums[i - 1];
                        nums[i - 1] = t;
                        break;
                    }
                }


                int start = i;
                int end = length - 1;
                while (start < end) {
                    int temp = nums[start];
                    nums[start] = nums[end];
                    nums[end] = temp;
                    start++;
                    end--;
                }

                find = true;
                break;
            }
        }

        if (!find) {
            int start = 0;
            int end = length - 1;
            while (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
    }
}
