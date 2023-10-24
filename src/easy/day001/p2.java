package easy.day001;

/**
 * @ClassName: p2
 * @Description:
 * @author: lyz
 * @date: 2023 10 2023/10/18 20:30
 */

class ListNode {
    int val;
    ListNode next;
    public ListNode(){}
    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


public class p2 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        addTwoNumbers(l1, l2);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode l = res;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        int carry = 0;
        while (cur1 != null || cur2 != null) {
            int value = 0;
            if (cur1 == null) {
                value = cur2.val + carry;
            } else if (cur2 == null) {
                value = cur1.val + carry;
            } else {
                value = cur1.val + cur2.val + carry;
            }
            res.next = new ListNode(value % 10);
            carry = value / 10;
            res = res.next;
            if (cur1 != null) {
                cur1 = cur1.next;
            }
            if (cur2 != null) {
                cur2 = cur2.next;
            }
        }
         if (carry != 0) {
             res.next = new ListNode(carry);
         }
        return l.next;
    }
}
