//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你能在不修改链表节点值的情况下解决这个问题吗?（也就是说，仅修改节点本身。） 
// Related Topics 递归 链表 
// 👍 818 👎 0


import java.util.Scanner;

//Java：两两交换链表中的节点
public class SwapNodesInPairs {
    public static void main(String[] args) {
        Solution solution = new SwapNodesInPairs().new Solution();
        // TO TEST
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入head链表:");
        String value = scanner.nextLine();
        int[] nums = Util.toIntegerArray(value);
        ListNode l1 = ListNode.get(nums);
        ListNode result = solution.swapPairs(l1);
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
        public ListNode swapPairs(ListNode head) {
            ListNode list = new ListNode();
            list.next = head;
            ListNode result = list;
            while (list.next != null) {
                ListNode next = list.next;
                if (next.next != null) {
                    list.next = next.next;
                    next.next = next.next.next;
                    list.next.next = next;
                }
                list = next;
            }
            return result.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}