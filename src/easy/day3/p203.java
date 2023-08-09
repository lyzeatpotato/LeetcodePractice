package easy.day3;

import java.util.Scanner;

/**
 * @ClassName: p203
 * @Description: 移除链表元素
 * @author: lyz
 * @date: 2023 07 2023/7/28 14:06
 */

public class p203 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String numStr = scan.nextLine();
        String[] strArr = numStr.split(" ");
        int[] nums = new int[strArr.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(strArr[i]);
        }
        int val = scan.nextInt();

        ListNode head = convertArrayToLinkNode(nums);

        ListNode result = removeElements(head, val);
    }

    public static ListNode removeElements(ListNode head, int val) {
        //带头结点的删除
        //新增虚拟头节点
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode pre = fakeHead;    //定义一个前指针指向上一个元素
        ListNode cur = pre.next;    //定义一个标志指针初始指向虚拟头节点
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                cur = cur.next;
            } else {
                //往后寻找
                pre = cur;
                cur = cur.next;
            }
        }
        return fakeHead.next;   //此处关键：不能返回head，要返回虚拟头节点后面的元素（可能删除头节点）
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
