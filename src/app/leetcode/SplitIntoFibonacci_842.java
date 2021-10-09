package app.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimmy
 */
public class SplitIntoFibonacci_842 {

    /**
     * 给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。
     * 形式上，斐波那契式序列是一个非负整数列表 F，且满足：
     * 0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
     * F.length >= 3；
     * 对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。
     * 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。
     * <p>
     * 返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入："123456579"
     * 输出：[123,456,579]
     * 示例 2：
     * <p>
     * 输入: "11235813"
     * 输出: [1,1,2,3,5,8,13]
     * 示例 3：
     * <p>
     * 输入: "112358130"
     * 输出: []
     * 解释: 这项任务无法完成。
     * 示例 4：
     * <p>
     * 输入："0123"
     * 输出：[]
     * 解释：每个块的数字不能以零开头，因此 "01"，"2"，"3" 不是有效答案。
     * 示例 5：
     * <p>
     * 输入: "1101111"
     * 输出: [110, 1, 111]
     * 解释: 输出 [11,0,11,11] 也同样被接受。
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= S.length <= 200
     * 字符串 S 中只含有数字。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/split-array-into-fibonacci-sequence
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param num
     * @return
     */
    public static void main(String[] args) {
        SplitIntoFibonacci_842 splitIntoFibonacci_842 = new SplitIntoFibonacci_842();
        List<Integer> list = splitIntoFibonacci_842.splitIntoFibonacci("123456579");
        List<Integer> list2 = splitIntoFibonacci_842.splitIntoFibonacci("11235813");
        List<Integer> list3 = splitIntoFibonacci_842.splitIntoFibonacci("112358130");
        List<Integer> list4 = splitIntoFibonacci_842.splitIntoFibonacci("1101111");
        List<Integer> list5 = splitIntoFibonacci_842.splitIntoFibonacci("0123");
        List<Integer> list6 = splitIntoFibonacci_842.splitIntoFibonacci("1011");
        int i = 1;
    }

    int[] numArr;
    public List<Integer> splitIntoFibonacci(String num) {
        numArr = new int[num.length()];
        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = num.charAt(i) - 48;
        }

        return backTracking(null, null, 0);
    }

    public List<Integer> backTracking(Integer pre, Integer pre2, int start) {
        List<Integer> ns = new ArrayList<>();
        int index = start;
        int num = 0;
        boolean isZeroStart = numArr[index] == 0;
        while (index < numArr.length) {
            num = num * 10 + numArr[index];
            if(isZeroStart && index != start) return new ArrayList<>();
            if (isMatch(pre, pre2, num)) {
                ns.add(num);
                if (index + 1 < numArr.length) {
                    List<Integer> subItems = backTracking(pre2, num, index + 1);
                    if (!subItems.isEmpty()) {
                        ns.addAll(subItems);
                        return ns;
                    } else {
                        ns.remove(ns.size() - 1);
                    }
                } else {
                    if(pre == null || pre2 == null) return new ArrayList<>();
                    return ns;
                }
            } else {
                int n = pre + pre2;
                if (num > n) {
                    ns.clear();
                    break;
                }
            }

            index++;
        }

        return ns;
    }

    private boolean isMatch(Integer pre, Integer pre2, int num) {
        if (pre == null || pre2 == null) return true;
        return pre + pre2 == num;
    }

    /**
     * 将给定的字符串拆分成斐波那契式序列，可以通过回溯的方法实现。
     *
     *
     * 使用列表存储拆分出的数，回溯过程中维护该列表的元素，列表初始为空。遍历字符串的所有可能的前缀，作为当前被拆分出的数，然后对剩余部分继续拆分，直到整个字符串拆分完毕。
     *
     * 行拆分，否则不进行拆分。
     *
     * 根据斐波那契式序列的要求，从第 33 个数开始，每个数都等于前 22 个数的和，因此从第 33 个数开始，需要判断拆分出的数是否等于前 22 个数的和，只有满足要求时才进行拆分，否则不进行拆分。
     *
     * 符合要求的，不可能继续拆分得到斐波那契式序列；
     *
     * 回溯过程中，还有三处可以进行剪枝操作。
     *
     * 拆分出的数如果不是 00，则不能以 00 开头，因此如果字符串剩下的部分以 00 开头，就不需要考虑拆分出长度大于 11 的数，因为长度大于 11 的数以 00 开头是不符合要求的，不可能继续拆分得到斐波那契式序列；
     *
     * 拆分出的数必须符合 3232 位有符号整数类型，即每个数必须在 [0,2^{31}-1][0,2
     * 31
     *  −1] 的范围内，如果拆分出的数大于 2^{31}-12
     *
     * 31
     *
     *  −1，则不符合要求，长度更大的数的数值也一定更大，一定也大于 2^{31}-12
     *
     * 31
     *
     *  −1，因此不可能继续拆分得到斐波那契式序列；
     * g-shu-zu-chai-fen-cheng-fei-bo-na-qi-ts6c/
     * 如果列表中至少有 22 个数，并且拆分出的数已经大于最后 22 个数的和，就不需要继续尝试拆分了。
     *
     * @param num
     * @return
     */
    public List<Integer> splitIntoFibonacciV2(String num) {
        List<Integer> list = new ArrayList<Integer>();
        backtrack(list, num, num.length(), 0, 0, 0);
        return list;
    }

    public boolean backtrack(List<Integer> list, String num, int length, int index, int sum, int prev) {
        if (index == length) {
            return list.size() >= 3;
        }
        long currLong = 0;
        for (int i = index; i < length; i++) {
            if (i > index && num.charAt(index) == '0') {
                break;
            }
            currLong = currLong * 10 + num.charAt(i) - '0';
            if (currLong > Integer.MAX_VALUE) {
                break;
            }
            int curr = (int) currLong;
            if (list.size() >= 2) {
                if (curr < sum) {
                    continue;
                } else if (curr > sum) {
                    break;
                }
            }
            list.add(curr);
            if (backtrack(list, num, length, i + 1, prev + curr, curr)) {
                return true;
            } else {
                list.remove(list.size() - 1);
            }
        }
        return false;
    }
}
