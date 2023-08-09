package easy.day4;

import java.util.Scanner;

/**
 * @ClassName: p24
 * @Description: 两两交换链表中的节点
 * @author: lyz
 * @date: 2023 07 2023/7/28 22:36
 */

public class p24 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String numStr = scan.nextLine();
        String[] strArr = numStr.split(" ");
        int[] nums = new int[strArr.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(strArr[i]);
        }
        ListNode head = convertArrayToListNode(nums);
        swapPairs(head);
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode fakedHead = new ListNode();
        fakedHead.next = head;      //将虚拟头节点连接到head指针
        ListNode pre = fakedHead;
        ListNode cur;        //作为当前链表位置的指针
        ListNode lat;
        ListNode temp;      //作为两个节点交换的后面的节点
        while (pre.next != null && pre.next.next != null) {
            temp = pre.next.next.next;
            cur = pre.next;
            lat = pre.next.next;
            pre.next = lat;       // 步骤一
            lat.next = cur; // 步骤二
            cur.next = temp;      // 步骤三
            pre = cur; // cur
        }
        return fakedHead.next;
    }

    public static ListNode convertArrayToListNode(int[] nums) {
        ListNode head = new ListNode(nums[0]);
        ListNode current = head;
        for (int i = 1; i < nums.length; i++) {
            ListNode temp = new ListNode(nums[i]);
            current.next = temp;
            current = current.next;
        }
        return head;
    }
}
