package easy.day3;

/**
 * @ClassName: p206
 * @Description: 反转链表
 * @author: lyz
 * @date: 2023 07 2023/7/28 16:19
 */

public class p206 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = convertArrayToLinkNode(nums);
        ListNode listNode = reverseList(head);
        System.out.println(1);
    }

    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        if (cur == null || cur.next == null) {
            return head;
        }
        ListNode lat = cur.next;
        while(cur != null) {
            cur.next = pre;
            pre = cur;
            cur = lat;
            if (lat != null) {
                lat = lat.next;
            } else {
                break;
            }
        }
        return pre;
    }

    public static ListNode convertArrayToLinkNode(int[] nums) {
        //将数组转换成ListNode
        //1.先创建一个根结点
        //2.创建一个other作为指针指向每次后方待插入的结点
        //3.每次新生成的结点存放在临时变量temp中
        ListNode head = new ListNode(nums[0]);
        ListNode other = head;   //用于记录根结点的临时变量
        for (int i = 1; i < nums.length; i++) {
            ListNode temp = new ListNode(nums[i]);
            other.next = temp;   //将head与新增结点连接
            other = temp;    //将head后移指向新增结点
        }
        return head;
    }
}
