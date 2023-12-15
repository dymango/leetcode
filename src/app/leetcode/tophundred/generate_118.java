package app.leetcode.tophundred;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimmy
 */
public class generate_118 {

    /**
     * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
     * <p>
     * 输入: numRows = 5
     * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
     * <p>
     * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
     *
     * @param numRows
     * @return
     */
    List<List<Integer>> r = new ArrayList<>();

    public List<List<Integer>> generate(int numRows) {
        r.add(List.of(1));
        for (int i = 2; i <= numRows; i++) {
            build(i);
        }

        return r;
    }

    private void build(int row) {
        List<Integer> lastRow = r.get(r.size() - 1);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i = 1; i < row - 1; i++) {
            list.add(lastRow.get(i - 1) + lastRow.get(i));
        }

        list.add(1);
        r.add(list);
    }
}
