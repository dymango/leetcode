package leetcodepractice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author dimmy
 */
public class TopKFrequent_692 {

    /**
     * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
     *
     * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
     *
     * 示例 1：
     *
     * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
     * 输出: ["i", "love"]
     * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
     *     注意，按字母顺序 "i" 在 "love" 之前。
     *  
     *
     * 示例 2：
     *
     * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
     * 输出: ["the", "is", "sunny", "day"]
     * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
     *     出现次数依次为 4, 3, 2 和 1 次。
     *  
     *
     * 注意：
     *
     * 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。
     * 输入的单词均由小写字母组成。
     *  
     *
     * 扩展练习：
     *
     * 尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。
     * @param words
     * @param k
     * @return
     */

    public static void main(String[] args) {
//        topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4);
        topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 3);
    }
    public static List<String> topKFrequent(String[] words, int k) {
        List<String> results = new ArrayList<>();
        Map<String, Integer> countMap = new HashMap<>();
        for (String word : words) {
            countMap.merge(word, 1, Integer::sum);
        }

        List<Integer> countList = countMap.values().stream().distinct().collect(Collectors.toList());
        countList.sort(Integer::compareTo);
        Map<Integer, List<String>> map = new HashMap<>();
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            Integer num = entry.getValue();
            if(map.get(num) == null) {
                map.put(num, new ArrayList<>());
            }

            map.get(num).add(entry.getKey());
            map.get(num).sort(String::compareTo);
        }

        for (int i = countList.size() - 1; i >= 0; i--) {
            Integer integer = countList.get(i);
            List<String> strings = map.get(integer);
            for (String string : strings) {
                if(results.size() < k) results.add(string);
                else return results;
            }
        }

        return results;
    }
}
