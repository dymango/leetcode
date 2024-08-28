package leetcodepractice.twohundred;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dimmy
 */
public class partition_131 {

    /**
     * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是
     * 回文串
     * 。返回 s 所有可能的分割方案。
     *
     * @param s
     * @return
     */

    boolean[][] match = new boolean[16][16];
    Map<String, List<List<String>>> map = new HashMap<>();

    public List<List<String>> partition(String s) {
        return backtrace(s, 0, s.length() - 1);
    }

    List<List<String>> backtrace(String s, int start, int end) {
        var key = start + "-" + end;
        if (map.containsKey(key)) return map.get(key);
        List<List<String>> r = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            int sp = start;
            int ep = i;
            boolean ishw = true;
            while (sp < ep) {
                if (s.charAt(sp) != s.charAt(ep)) {
                    ishw = false;
                    break;
                }
                sp++;
                ep--;
            }

            if (ishw) {
                var substring = s.substring(start, i + 1);
                var list = backtrace(s, i + 1, end);
                if(i + 1 > end) {
                    var l = new ArrayList<String>();
                    l.add(substring);
                    r.add(l);
                } else {
                    for (List<String> component : list) {
                        var objects = new ArrayList<>(component);
                        objects.addFirst(substring);
                        r.add(objects);
                    }
                }

            }
        }


        map.put(key, r);
        return r;
    }
}
