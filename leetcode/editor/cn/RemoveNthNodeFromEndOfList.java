//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
// Related Topics 链表 双指针 
// 👍 1215 👎 0


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//Java：删除链表的倒数第 N 个结点
public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
        // TO TEST
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入head数组:");
        String value = scanner.nextLine();
        int[] nums = Util.toIntegerArray(value);
        ListNode head = ListNode.get(nums);
        System.out.print("请输入n值:");
        value = scanner.nextLine();
        int target = Integer.parseInt(value);
        ListNode result = solution.removeNthFromEnd(head, target);
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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            /*
            ListNode list = new ListNode();
            list.next = head;
            ListNode p = list;
            ListNode q = list;
            for (int i = 0; i < n; i++) {
                p = p.next;
            }
            while (p.next != null) {
                p = p.next;
                q = q.next;
            }
            q.next = q.next.next;
            return list.next;
            */
            ListNode list = new ListNode();
            list.next = head;
            head = list;
            int count = 0;
            do {
                list = list.next;
                count++;
            } while (list.next != null);
            list = head;
            for (int i = 0; i < count - n; i++) {
                list = list.next;
            }
            ListNode node = null;
            if (list.next != null) {
                node = list.next.next;
            }
            list.next = node;
            return head.next;
            /*
            Map<Integer, ListNode> map = new HashMap<>();
            ListNode list = new ListNode();
            list.next = head;
            head = list;
            int count = -1;
            for (; list != null; list = list.next) {
                map.put(++count, list);
            }
            int index = count - n;
            int next = index + 2;
            if (next > count) {
                map.get(index).next = null;
            } else {
                map.get(index).next = map.get(next);
            }
            return head.next;
             */
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}