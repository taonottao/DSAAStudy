package exam;

import java.util.LinkedList;
import java.util.List;

class ListNode {
  int val;
  ListNode next = null;
  public ListNode(int val) {
    this.val = val;
  }
}

public class Demo20 {

    public ListNode partition (ListNode pHead, int x) {
        // write code here
        if(pHead == null || pHead.next == null){
            return pHead;
        }
        ListNode cur = pHead;
        ListNode pre = new ListNode(0);
        pre.next = cur;
        ListNode newHead = pre;
        ListNode tmp = pre;
        while (cur != null && cur.val < x) {
            cur = cur.next;
            pre = pre.next;
        }
        while (cur != null) {
            while (cur != null && cur.val >= x) {
                cur = cur.next;
            }
            if (cur.val < x) {
                tmp = cur.next;
                cur.next = pre.next;
                pre.next = cur;
            }
            cur = tmp;
        }
        return newHead.next;
    }

}
