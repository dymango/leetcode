package app.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dimmy
 */
public class NumMusicPlaylists_920 {

    /**
     * 你的音乐播放器里有 N 首不同的歌，在旅途中，你的旅伴想要听 L 首歌（不一定不同，即，允许歌曲重复）。请你为她按如下规则创建一个播放列表：
     * 每首歌至少播放一次。
     * 一首歌只有在其他 K 首歌播放完之后才能再次播放。
     * 返回可以满足要求的播放列表的数量。由于答案可能非常大，请返回它模 10^9 + 7 的结果。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：N = 3, L = 3, K = 1
     * 输出：6
     * 解释：有 6 种可能的播放列表。[1, 2, 3]，[1, 3, 2]，[2, 1, 3]，[2, 3, 1]，[3, 1, 2]，[3, 2, 1].
     * 示例 2：
     * <p>
     * 输入：N = 2, L = 3, K = 0
     * 输出：6
     * 解释：有 6 种可能的播放列表。[1, 1, 2]，[1, 2, 1]，[2, 1, 1]，[2, 2, 1]，[2, 1, 2]，[1, 2, 2]
     * 示例 3：
     * <p>
     * 输入：N = 2, L = 3, K = 1
     * 输出：2
     * 解释：有 2 种可能的播放列表。[1, 2, 1]，[2, 1, 2]
     *  
     * <p>
     * 提示：
     * <p>
     * 0 <= K < N <= L <= 100
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/number-of-music-playlists
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @param goal
     * @param k
     * @return
     */
    int N;
    int K;
    int GOAL;
    int result;
    int X = 1000000007;

    public int numMusicPlaylists(int n, int goal, int k) {
        N = n;
        K = k;
        GOAL = goal;
        result = 0;
        for (int i = 1; i <= N; i++) {
            ArrayList<Integer> songs = new ArrayList<>();
            HashMap<Integer, Integer> songCountMap = new HashMap<>();
            HashMap<Integer, Integer> indexMap = new HashMap<>();
            songs.add(i);
            songCountMap.put(i, 1);
            indexMap.put(i, 0);
            dfs(songs, songCountMap, indexMap);
        }

        return result;
    }

    private void dfs(List<Integer> songs, Map<Integer, Integer> songCountMap, Map<Integer, Integer> indexMap) {
        if (songs.size() == GOAL) {
            if (songCountMap.size() != N) return;
            result = (result + 1) % X;
            return;
        }

        if (N - songCountMap.size() > GOAL - songs.size()) return;
        for (int i = 1; i <= N; i++) {
            Integer preIndex = indexMap.getOrDefault(i, -1);
            if (preIndex == -1 || songs.size() - preIndex - 1 >= K) {
                songCountMap.merge(i, 1, Integer::sum);
                songs.add(i);
                indexMap.put(i, songs.size() - 1);
                dfs(songs, songCountMap, indexMap);
                songs.remove(songs.size() - 1);
                indexMap.put(i, preIndex);
                Integer merge = songCountMap.merge(i, -1, Integer::sum);
                if (merge <= 0) songCountMap.remove(i);
            }
        }
    }

    /**
     * 方法 1：动态规划
     * 想法
     * <p>
     * 令 dp[i][j] 为播放列表长度为 i 包含恰好 j 首不同歌曲的数量。我们需要计算 dp[L][N]，看上去可以通过 dp 来解决。
     * <p>
     * 算法
     * <p>
     * 考虑 dp[i][j]。最后一首歌，我们可以播放没有播放过的歌也可以是播放过的。如果未播放过的，那么就是 dp[i-1][j-1] * (N-j) 种选择方法。如果不是，那么就是选择之前的一首歌，dp[i-1][j] * max(j-K, 0)（j 首歌，最近的 K 首不可以播放）。
     * <p>
     * JavaPython
     * <p>
     * class Solution {
     * public int numMusicPlaylists(int N, int L, int K) {
     * int MOD = 1_000_000_007;
     * <p>
     * long[][] dp = new long[L+1][N+1];
     * dp[0][0] = 1;
     * for (int i = 1; i <= L; ++i)
     * for (int j = 1; j <= N; ++j) {
     * dp[i][j] += dp[i-1][j-1] * (N-j+1);
     * dp[i][j] += dp[i-1][j] * Math.max(j-K, 0);
     * dp[i][j] %= MOD;
     * }
     * <p>
     * return (int) dp[L][N];
     * }
     * }
     * 复杂度分析
     * <p>
     * 时间复杂度：O(NL)O(NL)。
     * 空间复杂度：O(NL)O(NL)。（然而，我们可以只存储最后一列的 dp 数组来优化空间，这样只需要 O(L)O(L) 的空间复杂度。）
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode.cn/problems/number-of-music-playlists/solution/bo-fang-lie-biao-de-shu-liang-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int numMusicPlaylistsV2(int N, int L, int K) {
        int MOD = 1_000_000_007;
        long[][] dp = new long[L + 1][N + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= L; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] += dp[i - 1][j - 1] * (N - j + 1);
                dp[i][j] += dp[i - 1][j] * Math.max(j - K, 0);
                dp[i][j] %= MOD;
            }
        }

        return (int) dp[L][N];
    }
}
