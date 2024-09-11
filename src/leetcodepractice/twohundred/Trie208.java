package leetcodepractice.twohundred;

/**
 * @author dimmy
 */
public class Trie208 {

    /**
     * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补全和拼写检查。
     * <p>
     * 请你实现 Trie 类：
     * <p>
     * Trie() 初始化前缀树对象。
     * void insert(String word) 向前缀树中插入字符串 word 。
     * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
     * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
     * <p>
     * <p>
     * 示例：
     * <p>
     * 输入
     * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
     * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
     * 输出
     * [null, null, true, false, true, null, true]
     * <p>
     * 解释
     * Trie trie = new Trie();
     * trie.insert("apple");
     * trie.search("apple");   // 返回 True
     * trie.search("app");     // 返回 False
     * trie.startsWith("app"); // 返回 True
     * trie.insert("app");
     * trie.search("app");     // 返回 True
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= word.length, prefix.length <= 2000
     * word 和 prefix 仅由小写英文字母组成
     * insert、search 和 startsWith 调用次数 总计 不超过 3 * 104 次
     */
    Node root;

    public Trie208() {
        root = new Node('0', false);
    }

    public void insert(String word) {
        var charArray = word.toCharArray();
        Node p = root;
        for (int i = 0; i < charArray.length; i++) {
            var c = charArray[i];
            var node = p.nodes[c - 'a'];
            if (node == null) {
                var next = new Node(c, i == charArray.length - 1);
                p.nodes[c - 'a'] = next;
                p = next;
            } else {
                if (i == charArray.length - 1) node.end = true;
                p = node;
            }
        }
    }

    public boolean search(String word) {
        var charArray = word.toCharArray();
        Node p = root;
        for (char c : charArray) {
            if (p.nodes[c - 'a'] == null) return false;
            p = p.nodes[c - 'a'];
        }

        return p.end;
    }

    public boolean startsWith(String prefix) {
        var charArray = prefix.toCharArray();
        Node p = root;
        for (char c : charArray) {
            if (p.nodes[c - 'a'] == null) return false;
            p = p.nodes[c - 'a'];
        }

        return true;
    }

    public static class Node {
        public char c;
        public boolean end;
        public Node[] nodes;

        public Node(char c, boolean end) {
            this.c = c;
            this.end = end;
            this.nodes = new Node[26];
        }
    }
}
