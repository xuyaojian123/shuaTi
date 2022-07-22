package 两两交换链表中的节点24;


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


    public ListNode swapPairs(ListNode head) {
        ListNode temp = head;
        while (temp!=null){
            if (temp.next!=null){
                temp.val = temp.val + temp.next.val;
                temp.next.val = temp.val - temp.next.val;
                temp.val = temp.val - temp.next.val;
                temp = temp.next.next;
            }else {
                temp = null;
            }
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
