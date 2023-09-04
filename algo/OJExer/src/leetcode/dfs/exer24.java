package leetcode.dfs;

/**
 * 两两交换链表中的节点
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/9/3 9:53
 */
public class exer24 {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode tmp = swapPairs(head.next.next);
        ListNode ret = head.next;
        ret.next = head;
        head.next = tmp;
        return ret;
    }
}
