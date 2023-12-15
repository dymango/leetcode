package app.leetcode.tophundred;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimmy
 */
public class getRow_119 {
    List<Integer> r = new ArrayList<>();

    public List<Integer> getRow(int numRows) {
        r = List.of(1);
        for (int i = 2; i <= numRows + 1; i++) {
            r = build(i);
        }

        return r;
    }

    private List<Integer> build(int row) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i = 1; i < row - 1; i++) {
            list.add(r.get(i - 1) + r.get(i));
        }

        list.add(1);
        return list;
    }
}
