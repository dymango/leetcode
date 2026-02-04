package leetcodepractice.leetcode;

import java.util.Collections;
import java.util.TreeMap;

/**
 * @author dimmy
 */
public class MinimumCost_3103 {

    /**
     * 给你一个下标从 0 开始长度为 n 的整数数组 nums 和两个 正 整数 k 和 dist 。
     * <p>
     * 一个数组的 代价 是数组中的 第一个 元素。比方说，[1,2,3] 的代价为 1 ，[3,4,1] 的代价为 3 。
     * <p>
     * 你需要将 nums 分割成 k 个 连续且互不相交 的子数组，满足 第二 个子数组与第 k 个子数组中第一个元素的下标距离 不超过 dist 。换句话说，如果你将 nums 分割成子数组 nums[0..(i1 - 1)], nums[i1..(i2 - 1)], ..., nums[ik-1..(n - 1)] ，那么它需要满足 ik-1 - i1 <= dist 。
     * <p>
     * 请你返回这些子数组的 最小 总代价。
     *
     *
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,3,2,6,4,2], k = 3, dist = 3
     * 输出：5
     * 解释：将数组分割成 3 个子数组的最优方案是：[1,3] ，[2,6,4] 和 [2] 。这是一个合法分割，因为 ik-1 - i1 等于 5 - 2 = 3 ，等于 dist 。总代价为 nums[0] + nums[2] + nums[5] ，也就是 1 + 2 + 2 = 5 。
     * 5 是分割成 3 个子数组的最小总代价。
     * 示例 2：
     *
     * @param nums
     * @param k
     * @param dist
     * @return
     *
     */
    public static void main(String[] args) {
        //输入：nums = [1,3,2,6,4,2], k = 3, dist = 3
        //[10,1,2,2,2,1] 4 , 3
        System.out.println(new MinimumCost_3103().minimumCost(new int[]{10, 1, 2, 2, 2, 1}, 4, 3));
        System.out.println(new MinimumCost_3103().minimumCost(new int[]{1, 3, 2, 6, 4, 2}, 3, 3));
        System.out.println(new MinimumCost_3103().minimumCost(new int[]{10, 8, 18, 9}, 3, 1));
        System.out.println(new MinimumCost_3103().minimumCost(new int[]{1, 1, 3}, 3, 1));
        System.out.println(new MinimumCost_3103().minimumCost(new int[]{2, 6, 3, 5}, 3, 1));
    }

    public long minimumCost(int[] nums, int k, int dist) {
        var length = nums.length;

        long sum = 0;
        MyHeap largeHeap = new MyHeap(true);
        MyHeap smallHeap = new MyHeap(false);

        for (int i = 1; i <= dist + 1; i++) {
            smallHeap.offer(nums[i]);
        }

        for (int i = 0; i < k - 1; i++) {
            if (!smallHeap.isEmpty()) {
                var poll = smallHeap.poll();
                largeHeap.offer(poll);
                sum += poll;
            }
        }

        long min = nums[0] + sum;
        for (int i = 1; i < length - dist; i++) {
            if (i > 1) {
                smallHeap.offer(nums[i + dist]);
                if (largeHeap.count < k - 1) {
                    var n = smallHeap.poll();
                    largeHeap.offer(n);
                    sum += n;
                } else {
                    if (!largeHeap.isEmpty() && !smallHeap.isEmpty() && largeHeap.peek() > smallHeap.peek()) {
                        var lp = largeHeap.poll();
                        sum -= lp;
                        var sp = smallHeap.poll();
                        largeHeap.offer(sp);
                        sum += sp;
                        smallHeap.offer(lp);
                    }
                }
            }

            min = Math.min(min, nums[0] + sum);

            if (smallHeap.contains(nums[i])) smallHeap.remove(nums[i]);
            else {
                largeHeap.remove(nums[i]);
                sum -= nums[i];
            }
        }

        return min;
    }


    public class MyHeap {
        public TreeMap<Integer, Integer> treeMap;
        public int count = 0;
        public int sum = 0;

        public MyHeap(boolean max) {
            if (max) this.treeMap = new TreeMap<>(Collections.reverseOrder());
            else this.treeMap = new TreeMap<>();
        }

        public boolean isEmpty() {
            return count == 0;
        }

        public Integer peek() {
            return treeMap.firstKey();
        }

        public Integer poll() {
            if (treeMap.isEmpty()) return null;
            count--;
            var entry = treeMap.firstEntry();
            sum -= entry.getKey();
            if (entry.getValue() > 1) {
                treeMap.put(entry.getKey(), entry.getValue() - 1);
                return entry.getKey();
            } else {
                return treeMap.pollFirstEntry().getKey();
            }
        }

        public void offer(int value) {
            if (treeMap.containsKey(value)) {
                treeMap.put(value, treeMap.get(value) + 1);
            } else {
                treeMap.put(value, 1);
            }

            sum += value;
            count++;
        }

        public void remove(int value) {
            var i = treeMap.get(value);
            if (i > 1) treeMap.put(value, i - 1);
            else treeMap.remove(value);
            count--;
        }

        public boolean contains(int value) {
            return treeMap.containsKey(value);
        }
    }
}
