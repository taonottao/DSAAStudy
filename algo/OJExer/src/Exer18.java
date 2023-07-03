/**
 * @version 1.0
 * @Author T-WANG
 * @Date 2023/7/3 19:37
 */

class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}

public class Exer18 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);
        ListNode head = Merge(l1, l2);
    }

    /**
     * 给定一个数组height，长度为n，每个数代表坐标轴中的一个点的高度，height[i]是在第i点的高度，
     * 请问，从中选2个高度与x轴组成的容器最多能容纳多少水
     * 1.你不能倾斜容器
     * 2.当n小于2时，视为不能形成容器，请返回0
     * 3.数据保证能容纳最多的水不会超过整形范围，即不会超过231-1
     */
    public int maxArea(int[] height) {
        // write code here
        if (height.length < 2) return 0;
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int h = Math.min(height[left], height[right]);
            max = Math.max(max, h * (right - left));
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }

        return max;
    }

    public static ListNode Merge(ListNode pHead1, ListNode pHead2) {
        // write code here
        if(pHead1==null) return pHead2;
        if(pHead2==null) return pHead1;

        ListNode cur1 = pHead1;
        ListNode cur2 = pHead2;
        ListNode head = (pHead1.val > pHead2.val ? pHead2 : pHead1);
        ListNode tmp = null;
        while (cur1 != null && cur2 != null) {
            while(cur1 != null && cur2 != null && cur1.val <= cur2.val) {
                tmp = cur1;
                cur1 = cur1.next;
            }
            if(tmp != null)
                tmp.next = cur2;
            while(cur1 != null && cur2 != null && cur2 != null && cur1.val > cur2.val){
                tmp = cur2;
                cur2 = cur2.next;
            }
            if(tmp != null)
                tmp.next = cur1;
        }
        // if(tmp != null)
        tmp.next = (cur1==null)? cur2 : cur1;

        return head;
    }

    /**
     * 判断链表是否有环
     */
    public boolean hasCycle(ListNode head) {
        if(head == null ) return false;
        if(head.next == null) return false;
        if(head.next.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while(slow != null && fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow!=null && fast!=null && slow.val == fast.val){
                return true;
            }
        }
        return false;
    }
}
