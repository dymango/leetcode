package leetcodepractice.vjudge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author dimmy
 * <p>
 * url -> https://vjudge.net/contest/419207#problem/A
 * 2 4 5
 * 40 20
 * 01
 * 01
 * 10
 * 11
 * 00 20
 * 00 40
 * 11 20
 * 11 40
 * 11 60
 */
public class TheWu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m, p;
        int[] nArr;
        String[] mArr;
        List<String> content = new ArrayList<>();
        if (scanner.hasNextLine()) {
            content.add(scanner.nextLine());
        }

        String[] input = content.get(0).split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.valueOf(input[1]);
        p = Integer.valueOf(input[2]);

        for (int i = 0; i < 1 + m + p; i++) {
            content.add(scanner.nextLine());
        }

        nArr = new int[n];
        String[] nItems = content.get(1).split(" ");
        for (int i = 0; i < nItems.length; i++) {
            nArr[i] = Integer.valueOf(nItems[i]);
        }

        mArr = new String[m];
        for (int i = 2; i < 2 + m; i++) {
            mArr[i - 2] = content.get(i);
        }

        Map<String, Integer> cache = new HashMap<>();
        for (int i = 2 + m; i < 2 + m + p; i++) {
            String[] pItem = content.get(i).split(" ");
            String s = pItem[0];
            int v = Integer.valueOf(pItem[1]);
            int count = 0;
            for (int j = 0; j < mArr.length; j++) {
                char[] sca = s.toCharArray();
                char[] mca = mArr[j].toCharArray();
                Integer sum = cache.get(s + j);
                if(sum == null) {
                    sum = 0;
                    for (int k = 0; k < sca.length; k++) {
                        if (sca[k] == mca[k]) sum += nArr[k];
                    }

                    cache.put(s + j, sum);
                }

                if (sum <= v) count++;
            }

            System.out.println(count);
        }
    }
}
