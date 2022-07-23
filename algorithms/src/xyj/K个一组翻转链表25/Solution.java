package xyj.K个一组翻转链表25;


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
                        //将 end 从链表中摘除 -
                        beg.next = end.next;
                        //将 end 移动至链表头
                        end.next = head_temp;
                        head_temp = end;
                        //调整 end 的指向，另其指向 beg 后的一个节点，为反转下一个节点做准备
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
