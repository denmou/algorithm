//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 
// 👍 1538 👎 0


import java.util.Scanner;

//Java：合并两个有序链表
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
        // TO TEST
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入l1链表:");
        String value = scanner.nextLine();
        int[] nums = Util.toIntegerArray(value);
        ListNode l1 = ListNode.get(nums);
        System.out.print("请输入l2链表:");
        value = scanner.nextLine();
        nums = Util.toIntegerArray(value);
        ListNode l2 = ListNode.get(nums);
        ListNode result = solution.mergeTwoLists(l1, l2);
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
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode node = new ListNode();
            ListNode head = node;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    node.next = l1;
                    node = node.next;
                    l1 = l1.next;
                } else {
                    node.next = l2;
                    node = node.next;
                    l2 = l2.next;
                }
            }
            if (l1 != null) {
                node.next = l1;
            }
            if (l2 != null) {
                node.next = l2;
            }
            return head.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}