package interview.experience.huawei;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @author dimmy
 */
public class HJ23 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        Set<Character> set = new HashSet<>();
        while (in.hasNext()) {
            String str = in.next();
            char[] chars = str.toCharArray();
            for (char aChar : chars) {
                characterIntegerMap.merge(aChar, 1, Integer::sum);
            }

            int min = characterIntegerMap.values().stream().min(Integer::compare).get();
            for (Map.Entry<Character, Integer> characterIntegerEntry : characterIntegerMap.entrySet()) {
                if (characterIntegerEntry.getValue() == min) set.add(characterIntegerEntry.getKey());
            }

            StringBuilder r = new StringBuilder();
            for (char aChar : chars) {
                if (!set.contains(aChar)) r.append(aChar);
            }

            System.out.println(r);
        }
    }
}
