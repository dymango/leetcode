package app.leetcode;

import app.executor.MainMethod;
import app.executor.MainParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dimmy
 */
public class NumPairsDivisibleBy60_1010 {
    @MainParam
    int[] time = {30, 20, 150, 100, 40};

    /**
     * 在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。
     * <p>
     *     (time[i] + time[j]) % 60 == 0。
     *     time[i]%60 + time[j]%60 == 60。
     * 返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。形式上，我们希望下标数字 i 和 j 满足  i < j 且有 (time[i] + time[j]) % 60 == 0。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：time = [30,20,150,100,40]
     * 输出：3
     * 解释：这三对的总持续时间可被 60 整除：
     * (time[0] = 30, time[2] = 150): 总持续时间 180
     * (time[1] = 20, time[3] = 100): 总持续时间 120
     * (time[1] = 20, time[4] = 40): 总持续时间 60
     * 示例 2：
     * <p>
     * 输入：time = [60,60,60]
     * 输出：3
     * 解释：所有三对的总持续时间都是 120，可以被 60 整除。
     * <p>
     * int n = time.size(), res = 0;
     * for (auto& x : time) x %= 60;
     * unordered_map<int, int> cnt;
     * for (auto& x : time) {
     * if (!x) res += cnt[0];
     * else res += cnt[60 - x];
     * cnt[x] ++ ;
     * }
     * return res;
     *
     * @param time
     * @return
     */

    @MainMethod
    public int numPairsDivisibleBy60V2(int[] time) {
        for (int i = 0; i < time.length; i++) {
            time[i] %= 60;
        }

        int[] count = new int[61];
        int result = 0;
        for (int t : time) {
            if (t == 0) result += count[0];
            else result += count[60 - t];

            count[t]++;
        }

        return result;
    }
}
