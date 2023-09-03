package leetcode.dfs;

/**
 * 反转链表
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/9/2 19:15
 */
public class Exer206 {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }
}
