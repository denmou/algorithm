/**
 * @author denmou
 * @date 2021/2/20 15:12
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    static ListNode get(int[] nums) {
        if (nums == null) {
            return null;
        }
        ListNode head = new ListNode();
        ListNode next = head;
        for (int item : nums) {
            ListNode node = new ListNode();
            node.val = item;
            next.next = node;
            next = node;
        }
        return head.next;
    }

    static void print(ListNode result) {
        System.out.print("执行结果为: [");
        if (result != null) {
            while (result.next != null) {
                System.out.print(result.val + ",");
                result = result.next;
            }
            System.out.print(result.val);
        }
        System.out.println("]");
    }
}
