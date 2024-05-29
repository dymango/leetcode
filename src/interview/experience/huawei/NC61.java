package interview.experience.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dimmy
 */
public class NC61 {

    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (!map.containsKey(numbers[i])) {
                map.put(numbers[i], new ArrayList<>());
            }

            map.get(numbers[i]).add(i);
        }

        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            int key = target - number;
            List<Integer> list = map.get(key);
            if(list == null) continue;
            for (Integer index : list) {
                if (index != i) {
                    int[] ints = {i + 1, index + 1};
                    Arrays.sort(ints);
                    return ints;
                }
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {
        twoSum(new int[]{5,75,25}, 100);
    }
}
