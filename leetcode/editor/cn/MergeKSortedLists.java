//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
// Related Topics 堆 链表 分治算法 
// 👍 1144 👎 0


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

//Java：合并K个升序链表
public class MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
        // TO TEST
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入list链表数组:");
        String value = scanner.nextLine();
        String[] array = value.split("],\\[");
        ListNode[] list = new ListNode[array.length];
        for (int i = 0; i < array.length; i++) {
            int[] nums = Util.toIntegerArray(array[i].replaceAll("[\\[|\\]]", ""));
            list[i] = ListNode.get(nums);
        }
        ListNode result = solution.mergeKLists(list);
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
        public ListNode mergeKLists(ListNode[] lists) {
            ListNode result = new ListNode();
            //queue(result, lists);
            conquer(result, lists);
            //loop(result, lists);
            return result.next;
        }

        private void loop(ListNode result, ListNode[] lists) {
            if (lists.length > 0) {
                ListNode node = lists[0];
                for (int i = 1; i < lists.length; i++) {
                    node = mergeTwoLists(node, lists[i]);
                }
                result.next = node;
            }
        }

        private void conquer(ListNode result, ListNode[] lists) {
            double count = lists.length;
            while (count > 1) {
                count = Math.ceil(count / 2.0);
                ListNode[] array = new ListNode[(int) count];
                for (int i = 0; i < lists.length; i++) {
                    if (i + 1 == lists.length) {
                        array[i / 2] = lists[i];
                    } else {
                        array[i / 2] = mergeTwoLists(lists[i], lists[++i]);
                    }
                }
                lists = array;
            }
            if (lists.length > 0) {
                result.next = lists[0];
            }
        }

        private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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

        private void queue(ListNode result, ListNode[] lists) {
            PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
            for (ListNode node : lists) {
                if (node != null) {
                    queue.add(node);
                }
            }
            while (!queue.isEmpty()) {
                ListNode node = queue.poll();
                result.next = node;
                result = result.next;
                node = node.next;
                if (node != null) {
                    queue.add(node);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}