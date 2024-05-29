package leetcodepractice.leetcode;

import java.util.Stack;

/**
 * @author dimmy
 */
public class Compress_443 {

    /**
     * 给定一组字符，使用原地算法将其压缩。
     *
     * 压缩后的长度必须始终小于或等于原数组长度。
     *
     * 数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
     *
     * 在完成原地修改输入数组后，返回数组的新长度。
     *
     *  
     *
     * 进阶：
     * 你能否仅使用O(1) 空间解决问题？
     *
     *  
     *
     * 示例 1：
     *
     * 输入：
     * ["a","a","b","b","c","c","c"]
     *
     * 输出：
     * 返回 6 ，输入数组的前 6 个字符应该是：["a","2","b","2","c","3"]
     *
     * 说明：
     * "aa" 被 "a2" 替代。"bb" 被 "b2" 替代。"ccc" 被 "c3" 替代。
     * 示例 2：
     *
     * 输入：
     * ["a"]
     *
     * 输出：
     * 返回 1 ，输入数组的前 1 个字符应该是：["a"]
     *
     * 解释：
     * 没有任何字符串被替代。
     * 示例 3：
     *
     * 输入：
     * ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
     *
     * 输出：
     * 返回 4 ，输入数组的前4个字符应该是：["a","b","1","2"]。
     *
     * 解释：
     * 由于字符 "a" 不重复，所以不会被压缩。"bbbbbbbbbbbb" 被 “b12” 替代。
     * 注意每个数字在数组中都有它自己的位置。
     *  
     *
     * 提示：
     *
     * 所有字符都有一个ASCII值在[35, 126]区间内。
     * 1 <= len(chars) <= 1000。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/string-compression
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param chars
     * @return
     */
    public static int compress(char[] chars) {
        int fastPointer = 0;
        int lowPointer = 0;
        for (int i = 0; i < chars.length; i++) {
            if(i + 1 == chars.length || chars[i + 1] != chars[i]) {
                chars[lowPointer++] = chars[fastPointer];
                if(i > fastPointer) {
                    for (char c : (String.valueOf(i - fastPointer + 1).toCharArray())) {
                        chars[lowPointer++] = c;
                    }
                }

                fastPointer = i + 1;
            }
        }

        return lowPointer;
    }


    public static int compress2(char[] chars) {
        int anchor = 0, write = 0;
        for (int read = 0; read < chars.length; read++) {
            if (read + 1 == chars.length || chars[read + 1] != chars[read]) {
                chars[write++] = chars[anchor];
                if (read > anchor) {
                    for (char c: ("" + (read - anchor + 1)).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                anchor = read + 1;
            }
        }
        return write;
    }



    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    /**
     * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
     *
     * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
     *
     *  
     *
     * 进阶：
     *
     * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
     *
     *  
     *
     * 示例：
     *
     * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 8 -> 0 -> 7
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param l1
     * @param l2
     * @return
     */
    public  static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> l1Stack = new Stack<>();
        Stack<Integer> l2Stack = new Stack<>();
        while(l1 != null) {
            l1Stack.push(l1.val);
            l1 = l1.next;
        }

        while(l2 != null) {
            l2Stack.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        String str = "";
        ListNode node = null;
        while(!l1Stack.isEmpty() || !l2Stack.isEmpty() || carry != 0) {
            int l1v = l1Stack.isEmpty() ? 0 : l1Stack.pop();
            int l2v = l2Stack.isEmpty() ? 0 : l2Stack.pop();
            int sum = l1v + l2v + carry;
            int value = sum % 10;
            carry = sum / 10;
            str = value + str;
            if(node == null) {
                node = new ListNode(value);
            } else {
                ListNode head = new ListNode(value);
                head.next = node;
                node = head;
            }
        }

        return node;
    }

    public static void main(String[] args) {
//        compress2(new char[]{'a','a','b','b','c','c','c'});
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(9);
        ListNode l3 = new ListNode(9);
        ListNode l4 = new ListNode(9);
        ListNode l5 = new ListNode(9);
        ListNode l6 = new ListNode(9);
        ListNode l7 = new ListNode(9);
        ListNode l8 = new ListNode(9);
        ListNode l9 = new ListNode(9);
        ListNode l10 = new ListNode(9);
        ListNode l11 = new ListNode(7);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        l8.next = l9;
        l9.next = l10;
        addTwoNumbers(l1, l11);
    }
}
