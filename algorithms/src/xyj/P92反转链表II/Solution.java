package xyj.P92��ת����II;

public class Solution {


    // ͷ�巨����ת����
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // ����һ��dummyHead, ���㴦��
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        // ��ʼ��ָ��
        ListNode g = dummyHead;
        ListNode p = dummyHead.next;

        // ��ָ���Ƶ���Ӧ��λ��
        for(int step = 0; step < m - 1; step++) {
            g = g.next; p = p.next;
        }

        // ͷ�巨����ڵ�
        for (int i = 0; i < n - m; i++) {
            ListNode removed = p.next;
            p.next = p.next.next;

            removed.next = g.next;
            g.next = removed;
        }

        return dummyHead.next;
    }



    //�ݹ鷴ת��������
    public ListNode reverse(ListNode head) {
        if (head==null || head.next == null){
            return head;
        }
        // ���õ��ƹ�ʽ��ת��ǰ���֮������нڵ�
        // ���صĽ���Ƿ�ת��������ͷ���
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    // �ݹ鷴תǰn���ڵ�
    ListNode successor = null;//��¼��n+1���ڵ�
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

    // �ݹ鷴ת�����һ����
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
