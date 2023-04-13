package xyj.P92反转链表II;

public class Solution {


    // 头插法，反转链表
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // 定义一个dummyHead, 方便处理
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        // 初始化指针
        ListNode g = dummyHead;
        ListNode p = dummyHead.next;

        // 将指针移到相应的位置
        for(int step = 0; step < m - 1; step++) {
            g = g.next; p = p.next;
        }

        // 头插法插入节点
        for (int i = 0; i < n - m; i++) {
            ListNode removed = p.next;
            p.next = p.next.next;

            removed.next = g.next;
            g.next = removed;
        }

        return dummyHead.next;
    }



    //递归反转整个链表
    public ListNode reverse(ListNode head) {
        if (head==null || head.next == null){
            return head;
        }
        // 调用递推公式反转当前结点之后的所有节点
        // 返回的结果是反转后的链表的头结点
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    // 递归反转前n个节点
    ListNode successor = null;//记录第n+1个节点
    public ListNode reverseN(ListNode head, int n) {
        if (n == 1){
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    // 递归反转链表的一部分
    public ListNode reverseBetween_1(ListNode head, int m, int n) {
        if (m == 1){
            return reverseN(head, n );
        }
        ListNode node = reverseBetween_1(head.next, m - 1, n - 1);
        head.next = node;
        return head;
    }



    public static void main(String[] args) {


    }

}
