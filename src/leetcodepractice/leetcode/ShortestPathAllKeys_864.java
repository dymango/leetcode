package leetcodepractice.leetcode;


import leetcodepractice.core.UnResolve;

/**
 * @author dimmy
 */
@UnResolve(type = "graph")
public class ShortestPathAllKeys_864 {

    /**
     * 给定一个二维网格 grid。 "." 代表一个空房间， "#" 代表一堵墙， "@" 是起点，（"a", "b", ...）代表钥匙，（"A", "B", ...）代表锁。
     * 我们从起点开始出发，一次移动是指向四个基本方向之一行走一个单位空间。我们不能在网格外面行走，也无法穿过一堵墙。如果途经一个钥匙，我们就把它捡起来。除非我们手里有对应的钥匙，否则无法通过锁。
     * 假设 K 为钥匙/锁的个数，且满足 1 <= K <= 6，字母表中的前 K 个字母在网格中都有自己对应的一个小写和一个大写字母。换言之，每个锁有唯一对应的钥匙，每个钥匙也有唯一对应的锁。另外，代表钥匙和锁的字母互为大小写并按字母顺序排列。
     * 返回获取所有钥匙所需要的移动的最少次数。如果无法获取所有钥匙，返回 -1 。
     *  
     *
     * 示例 1：
     * 输入：["@.a.#","###.#","b.A.B"]
     * 输出：8
     * 示例 2：
     *
     * 输入：["@..aA","..B#.","....b"]
     * 输出：6
     *  
     *
     * 提示：
     * 1 <= grid.length <= 30
     * 1 <= grid[0].length <= 30
     * grid[i][j] 只含有 '.', '#', '@', 'a'-'f' 以及 'A'-'F'
     * 钥匙的数目范围是 [1, 6]，每个钥匙都对应一个不同的字母，正好打开一个对应的锁。
     *
     * @param grid
     * @return
     */
    //todo
    public int shortestPathAllKeys(String[] grid) {
        return 1;
    }
}
