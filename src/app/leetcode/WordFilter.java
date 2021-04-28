package app.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author dimmy
 */
public class WordFilter {

    /**
     * 给定多个 words，words[i] 的权重为 i 。
     * 设计一个类 WordFilter 实现函数WordFilter.f(String prefix, String suffix)。这个函数将返回具有前缀 prefix 和后缀suffix 的词的最大权重。如果没有这样的词，返回 -1。
     *
     * 例子:
     *
     * 输入:
     * WordFilter(["apple"])
     * WordFilter.f("a", "e") // 返回 0
     * WordFilter.f("b", "") // 返回 -1
     * 注意:
     *
     * words的长度在[1, 15000]之间。
     * 对于每个测试用例，最多会有words.length次对WordFilter.f的调用。
     * words[i]的长度在[1, 10]之间。
     * prefix, suffix的长度在[0, 10]之前。
     * words[i]和prefix, suffix只包含小写字母。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/prefix-and-suffix-search
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param words
     */
    public static void main(String[] args) {
        WordFilter wordFilter = new WordFilter(new String[]{"apple", "aced", "abcaccbcaa"});
//        System.out.println(wordFilter.f("a", "e"));
//        System.out.println(wordFilter.f("a", "c"));
//        System.out.println(wordFilter.f("a", "d"));
        System.out.println(wordFilter.f("ab","abcaccbcaa"));
    }

    static Node node = new Node(-1, -1);
    static Node reverseNode = new Node(-1, -1);
    Map<String, List<Integer>> preCache = new HashMap<>();
    Map<String, List<Integer>> sufCache = new HashMap<>();
    public WordFilter(String[] words) {
        for (int i = 0; i < words.length; i++) {
            insertNode(node, words[i], 0, i);
            insertReverseNode(reverseNode, words[i], words[i].length() - 1, i);
        }
    }

    public int f(String prefix, String suffix) {
        List<Integer> set = findPrefix(node, prefix);
        if(set.size() == 0) return -1;
        List<Integer> set2 = findSuffix(reverseNode, suffix);
        if(set2.size() == 0) return -1;
        for (int i = set.size() - 1; i >= 0 ; i--) {
            for (int i1 = set2.size() - 1; i1 >= 0; i1--) {
                if(set.get(i) == set2.get(i1)) return set.get(i);
            }
        }

        return -1;
    }

    private List<Integer> findPrefix(Node node, String prefix) {
        List<Integer> list = preCache.get(prefix);
        if(list != null) return list;
        Node nodeView = node;
        for (int i = 0; i < prefix.length(); i++) {
            nodeView = nodeView.nodes[prefix.charAt(i) - 97];
            if(nodeView == null) return new ArrayList<>();
        }

        preCache.put(prefix, nodeView.endIndexSet);
        return nodeView.endIndexSet;
    }

    private List<Integer> findSuffix(Node node, String suffix) {
        List<Integer> list = sufCache.get(suffix);
        if(list != null) return list;
        Node nodeView = node;
        for (int i = suffix.length() - 1; i >= 0; i--) {
            nodeView = nodeView.nodes[suffix.charAt(i) - 97];
            if(nodeView == null) return new ArrayList<>();
        }

        sufCache.put(suffix, nodeView.endIndexSet);
        return nodeView.endIndexSet;
    }


    public static class Node {
        int value;
        List<Integer> endIndexSet;
        Node[] nodes;

        public Node(int value, int index) {
            this.value = value;
            endIndexSet = new ArrayList<>();
            endIndexSet.add(index);
            this.nodes = new Node[26];
        }
    }

    private static void insertNode(Node node, String str, int index, int weight) {
        if(index >= str.length()) return;
        int c = str.charAt(index) - 97;
        Node nodeView = node.nodes[c];
        if(nodeView == null) {
            nodeView = new Node(str.charAt(index), weight);
            node.nodes[c] = nodeView;
        }

        node.nodes[c].endIndexSet.add(weight);
        insertNode(node.nodes[c], str, index + 1, weight);
    }

    private static void insertReverseNode(Node node, String str, int index, int weight) {
        if(index < 0) return;
        int c = str.charAt(index) - 97;
        Node nodeView = node.nodes[c];
        if(nodeView == null) {
            nodeView = new Node(str.charAt(index), weight);
            node.nodes[c] = nodeView;
        }

        node.nodes[c].endIndexSet.add(weight);
        insertReverseNode(node.nodes[c], str, index - 1, weight);
    }
}
