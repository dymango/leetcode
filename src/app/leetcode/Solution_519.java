package app.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * @author dimmy
 */
public class Solution_519 {
    /**
     * 题中给出一个 n_rows 行 n_cols 列的二维矩阵，且所有值被初始化为 0。要求编写一个 flip 函数，均匀随机的将矩阵中的 0 变为 1，并返回该值的位置下标 [row_id,col_id]；同样编写一个 reset 函数，将所有的值都重新置为 0。尽量最少调用随机函数 Math.random()，并且优化时间和空间复杂度。
     *
     * 注意:
     *
     * 1 <= n_rows, n_cols <= 10000
     * 0 <= row.id < n_rows 并且 0 <= col.id < n_cols
     * 当矩阵中没有值为 0 时，不可以调用 flip 函数
     * 调用 flip 和 reset 函数的次数加起来不会超过 1000 次
     * 示例 1：
     *
     * 输入:
     * ["Solution","flip","flip","flip","flip"]
     * [[2,3],[],[],[],[]]
     * 输出: [null,[0,1],[1,2],[1,0],[1,1]]
     * 示例 2：
     *
     * 输入:
     * ["Solution","flip","flip","reset","flip"]
     * [[1,2],[],[],[],[]]
     * 输出: [null,[0,0],[0,1],null,[0,0]]
     * 输入语法解释：
     *
     * 输入包含两个列表：被调用的子程序和他们的参数。Solution 的构造函数有两个参数，分别为 n_rows 和 n_cols。flip 和 reset 没有参数，参数总会以列表形式给出，哪怕该列表为空
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/random-flip-matrix
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param n_rows
     * @param n_cols
     */
    int row;
    int col;
    List<Node> nodes = new ArrayList<>();
    public Solution_519(int n_rows, int n_cols) {
        row = n_rows;
        col = n_cols;
    }

    public int[] flip() {
        int x = new Random().nextInt(row);
        int y = new Random().nextInt(col);
        while(nodes.contains(new Node(x, y))) {
            x = new Random().nextInt(row);
            y = new Random().nextInt(col);
        }

        nodes.add(new Node(x, y));
        return new int[]{x, y};
    }

    public void reset() {
        nodes.clear();
    }

    public class Node {
        public int x;
        public int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x &&
                    y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
