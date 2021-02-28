//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 
//
// 示例： 
//
// 给你这个链表：1->2->3->4->5 
//
// 当 k = 2 时，应当返回: 2->1->4->3->5 
//
// 当 k = 3 时，应当返回: 3->2->1->4->5 
//
// 
//
// 说明： 
//
// 
// 你的算法只能使用常数的额外空间。 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
// Related Topics 链表 
// 👍 910 👎 0


import java.util.Scanner;

//Java：K 个一组翻转链表
public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        Solution solution = new ReverseNodesInKGroup().new Solution();
        // TO TEST
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入head链表:");
        String value = scanner.nextLine();
        int[] nums = Util.toIntegerArray(value);
        ListNode head = ListNode.get(nums);
        System.out.print("请输入k值:");
        value = scanner.nextLine();
        int target = Integer.parseInt(value);
        ListNode result = solution.reverseKGroup(head, target);
        ListNode.print(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode list = new ListNode();
            list.next = head;
            ListNode start = list;
            ListNode end = list;
            while (true) {
                for (int i = 0; i < k; i++) {
                    end = end.next;
                    if (end == null) {
                        return list.next;
                    }
                }
                ListNode first = start.next;
                ListNode next = first;
                ListNode last = first.next;
                for (int i = 1; i < k; i++) {
                    next.next = last.next;
                    last.next = first;
                    first = last;
                    last = next.next;
                }
                start.next = first;
                end = next;
                start = end;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}