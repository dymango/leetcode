package leetcodepractice.twohundred;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class numDecodings91 {

    Map<String, String> map = new HashMap<>();

    public int numDecodings(String s) {
        if (s.startsWith("0")) return 0;
        for (int i = 1; i <= 26; i++) {
            map.put(String.valueOf(i), String.valueOf((char) ('A' - 1 + i)));
        }

        int[] count = new int[s.length()];
        count[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '0') {
                count[i] = count[i - 1];
                String substring = s.substring(i - 1, i + 1);
                if (map.containsKey(substring)) {
                    if (i - 2 >= 0) count[i] += count[i - 2];
                    else count[i] += 1;
                }
            } else {
                String substring = s.substring(i - 1, i + 1);
                if (map.containsKey(substring)) {
                    if (i - 2 >= 0) count[i] += count[i - 2];
                    else count[i] += 1;
                } else return 0;
            }
        }

        return count[count.length - 1];
    }

    List<String> count(String str) {
        List<String> list = new ArrayList<>();
        if (str.length() == 1 || str.length() == 2) {
            String s = map.get(str);
            if (s != null) list.add(s);

        }
        if (str.isEmpty() || str.startsWith("0")) return new ArrayList<>();

        for (int i = 1; i < str.length(); i++) {
            List<String> count = count(str.substring(0, i));
            List<String> count2 = count(str.substring(i));
            if (!count.isEmpty() && !count2.isEmpty()) {
                for (String s : count) {
                    for (String string : count2) {
                        list.add(s + string);
                    }
                }
            }
        }


        return list;
    }

    public static void main(String[] args) {
        System.out.println(new numDecodings91().numDecodings("226"));
    }
}
