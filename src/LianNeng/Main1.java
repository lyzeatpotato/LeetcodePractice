package LianNeng;

/**
 * @ClassName: Main1
 * @Description:
 * @author: lyz
 * @date: 2023 09 2023/9/17 16:32
 */

public class Main1 {
    public static void main(String[] args) {
        ListNode pHead = new ListNode(1);
        pHead.next = new ListNode(4);
        pHead.next.next = new ListNode(3);
        partition(pHead, 4);
    }

    public static ListNode partition (ListNode pHead, int x) {
        // write code here
        ListNode fakeNode = new ListNode(0);
        fakeNode.next = pHead;
        ListNode curNode = pHead;
        ListNode insertPlace = pHead;   //指针：指向待插入的位置
        ListNode preNode = fakeNode;
        while (curNode != null) {
            if (curNode.val < x) {
                ListNode temp = new ListNode(curNode.val);

                //将原有位置的元素删除
                preNode.next = curNode.next;

                //将当前元素插入到应该放在的位置上
                temp.next = insertPlace.next;
                insertPlace.next = temp;

                //更新插入位置的指针
                insertPlace = curNode;
            }
            preNode = curNode;
            curNode = curNode.next; //指针后移
        }
        return fakeNode.next;
    }
}
