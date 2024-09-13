package leetcodepractice.twohundred;

import java.util.Arrays;
import java.util.List;

public class minimumTotal120 {

    public static void main(String[] args) {
        new minimumTotal120().minimumTotal(List.of(List.of(2),List.of(3,4),List.of(6,5,7),List.of(4,1,8,3) ));
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.getLast().size();
        int[] sumArr = new int[size];
        int[] cur = new int[size];
        int pre = 0;
        for (int i = 0; i < triangle.size(); i++) {
            List<Integer> t = triangle.get(i);
            cur[0] = t.get(0) + sumArr[0];
            for (int j = 1; j < t.size(); j++) {
                Integer v = t.get(j);
                if(j <= pre - 1) cur[j] = Math.min(v + sumArr[j], v + sumArr[j - 1]);
                else cur[j] = v + sumArr[j - 1];
            }

            sumArr = Arrays.copyOf(cur, cur.length);
            pre = t.size();
        }

        int min = Integer.MAX_VALUE;
        for (int s : sumArr) {
            min = Math.min(min, s);
        }
        return min;
    }
}
