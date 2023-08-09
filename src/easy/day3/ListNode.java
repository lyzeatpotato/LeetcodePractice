package easy.day3;

/**
 * @ClassName: ListNode
 * @Description: 链表数据结构
 * @author: lyz
 * @date: 2023 07 2023/7/28 16:20
 */

public class ListNode {
    int val;    //值
    ListNode next;  //下个元素

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
