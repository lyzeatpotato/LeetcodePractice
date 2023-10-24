package LianNeng;

/**
 * @ClassName: Main3
 * @Description:
 * @author: lyz
 * @date: 2023 09 2023/9/17 17:35
 */

public class Main3 {
    public static void main(String[] args) {
        ListNode pHead = new ListNode(1);
        pHead.next = new ListNode(4);
        pHead.next.next = new ListNode(3);
        partition(pHead, 4);
    }

    public static ListNode partition (ListNode pHead, int x) {
        // write code here
        ListNode smallHead = new ListNode(0);
        ListNode smallTail = smallHead;
        ListNode bigHead = new ListNode(0);
        ListNode bigTail = bigHead;
        ListNode cur = pHead;
        while (cur != null) {
            if (cur.val < x) {
                smallTail.next = new ListNode(cur.val);
                smallTail = smallTail.next;
            } else {
                bigTail.next = new ListNode(cur.val);
                bigTail = bigTail.next;
            }
            cur = cur.next;
        }
        smallTail.next = bigHead.next;
        return smallHead.next;
    }
}
