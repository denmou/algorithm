/*
//评测题目: 无

给出两个 非空 的链表用来表示两个非负的整数。它们各自的位数是按照 逆序 的方式存储的，
并且它们的每个节点只能存储 一位 数字。将这两个数相加起来，则会返回一个新的链表来表示它们的和。
这两个非负整数都不会以 0 开头，您可以不考虑数字0开头的特殊情况。
示例如下:
输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
 */

import java.util.Scanner;

/**
 * @author denmou
 * @date 2021/2/24 21:03
 */
public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("node1:");
        String value = scanner.nextLine();
        String[] array = value.split(",");
        Node node1 = new Node();
        Node head = node1;
        if (value.length() > 0) {
            for (String item : array) {
                int target = Integer.parseInt(item);
                node1.next = new Node(target, null);
                node1 = node1.next;
            }
        }
        node1 = head.next;
        System.out.print("node2:");
        value = scanner.nextLine();
        array = value.split(",");
        Node node2 = new Node();
        head = node2;
        if (value.length() > 0) {
            for (String item : array) {
                int target = Integer.parseInt(item);
                node2.next = new Node(target, null);
                node2 = node2.next;
            }
        }
        node2 = head.next;
        Test test = new Test();
        Node result = test.add(node1, node2);
        System.out.print("result: [");
        if (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
        while (result != null) {
            System.out.print("," + result.val);
            result = result.next;
        }
        System.out.println("]");
    }

    public Node add(Node node1, Node node2) {
        int count = 0;
        Node head = node1;
        if (node1 == null) {
            if (node2 == null) {
                return new Node(0, null);
            } else {
                return node2;
            }
        }
        Node next = node1;
        while (node1 != null && node2 != null) {
            node1.val += node2.val + count;
            if (node1.val >= 10) {
                node1.val -= 10;
                count = 1;
            } else {
                count = 0;
            }
            next = node1;
            node1 = node1.next;
            node2 = node2.next;
        }
        if (node2 != null) {
            next.next = node2;
            node1 = node2;
        }
        while (node1 != null && count > 0) {
            node1.val += count;
            if (node1.val >= 10) {
                node1.val -= 10;
                count = 1;
            } else {
                count = 0;
            }
            next = node1;
            node1 = node1.next;
        }
        if (count > 0) {
            next.next = new Node(1, null);
        }
        return head;
    }
}

class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}


