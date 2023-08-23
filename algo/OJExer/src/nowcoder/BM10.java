package nowcoder;

/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/8/22 14:13
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class BM10 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode cur1 = pHead1;
        ListNode cur2 = pHead2;
        int i = 0;
        while (cur1 != null && cur2 != null) {
            i++;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        int j = 0;
        if (cur1 != null) {
            while (cur1 != null) {
                j++;
                cur1 = cur1.next;
            }
            while (j > 0) {
                pHead1 = pHead1.next;
                j--;
            }
        } else if (cur2 != null) {
            while (cur2 != null) {
                j++;
                cur2 = cur2.next;
            }
            while (j > 0) {
                pHead2 = pHead2.next;
                j--;
            }
        }
        while (pHead1 != null && pHead2 != null && pHead1 != pHead2) {
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return pHead1;
    }
}
