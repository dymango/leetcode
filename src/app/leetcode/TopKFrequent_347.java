package app.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @author dimmy
 */
public class TopKFrequent_347 {
    //[4,1,-1,2,-1,2,3]
    //2
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            map.merge(n, 1, Integer::sum);
        }

        List<Map.Entry<Integer, Integer>> List = map.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).collect(Collectors.toList());
        int[] result = new int[k];
        int index = 0;
        for (Map.Entry<Integer, Integer> integer : List) {
            result[index++] = integer.getKey();
            if(index >= k) break;
        }

        return result;
    }

    public static void main(String[] args) {
        topKFrequent(new int[]{4,1,-1,2,-1,2,3}, 2);
    }
}
