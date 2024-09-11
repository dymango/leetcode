package leetcodepractice.twohundred;

import java.util.Arrays;

/**
 * @author dimmy
 */
public class WordDictionary_211 {

    /**
     * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
     *
     * 实现词典类 WordDictionary ：
     *
     * WordDictionary() 初始化词典对象
     * void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
     * bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
     *
     *
     * 示例：
     *
     * 输入：
     * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
     * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
     * 输出：
     * [null,null,null,null,false,true,true,true]
     *
     * 解释：
     * WordDictionary wordDictionary = new WordDictionary();
     * wordDictionary.addWord("bad");
     * wordDictionary.addWord("dad");
     * wordDictionary.addWord("mad");
     * wordDictionary.search("pad"); // 返回 False
     * wordDictionary.search("bad"); // 返回 True
     * wordDictionary.search(".ad"); // 返回 True
     * wordDictionary.search("b.."); // 返回 True
     */
    Node root;

    public WordDictionary_211() {
        root = new Node(false);
    }

    public void addWord(String word) {
        var p = root;
        var charArray = word.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            var c = word.charAt(i);
            var node = p.nodes[c - 'a'];
            if (node == null) {
                var next = new Node(i == charArray.length - 1);
                p.nodes[c - 'a'] = next;
                p = next;
            } else {
                if(i == charArray.length - 1) {
                    node.end = true;
                }

                p = node;
            }
        }
    }

    public boolean search(String word) {
        return search(word, root);
    }

    public boolean search(String word, Node n) {
        if (n == null) return false;
        if (word.isEmpty()) return true;
        var p = n;
        var charArray = word.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            var c = word.charAt(i);
            if (c == '.') {
                if (i == charArray.length - 1) {
                    return Arrays.stream(p.nodes).anyMatch(node -> node != null && node.end);
                }
                for (Node node : p.nodes) {
                    var search = search(word.substring(i + 1), node);
                    if (search) return true;
                }

                return false;
            } else {
                var node = p.nodes[c - 'a'];
                if (node == null) return false;
                p = node;
            }
        }

        return p.end;
    }

    public static class Node {
        public Node[] nodes;
        public boolean end;

        public Node(boolean end) {
            this.end = end;
            nodes = new Node[26];
        }
    }
}
