package xyj.K��һ�鷭ת����25;


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode beg = head;
        ListNode end = head.next;
        ListNode head_temp = head;
        ListNode result = new ListNode(0);
        ListNode sk = result;
        while (true){
            int ans = 0;
            while (temp!=null){
                ans ++;
                temp = temp.next;
                if (ans == k){
                    while (end != temp) {
                        //�� end ��������ժ�� -
                        beg.next = end.next;
                        //�� end �ƶ�������ͷ
                        end.next = head_temp;
                        head_temp = end;
                        //���� end ��ָ������ָ�� beg ���һ���ڵ㣬Ϊ��ת��һ���ڵ���׼��
                        end = beg.next;
                    }
                    beg.next = null;
                    sk.next = head_temp;
                    sk = beg;
                    head_temp = end;
                    beg = end;
                    end = end!=null?end.next:null;
                    break;
                }
            }
            if (ans < k){
                sk.next = beg;
                break;
            }
        }
        return result.next;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        //ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        //d.next = e;
        solution.reverseKGroup(a,2);

    }
}
