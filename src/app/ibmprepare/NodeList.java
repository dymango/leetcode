package app.ibmprepare;

import app.leetcode.base.Node;

/**
 * @author dimmy
 */
public class NodeList {

    public static void main(String[] args) {
        Node n = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        new NodeList().reverseNodeList(n);
    }

    public void reverseNodeList(Node node) {
        Node pre = null;
        Node current = node;
        while (current != null) {
            Node temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
        }

        node = pre;
        int i =1;
    }

    public void r(Node node) {

    }
}
