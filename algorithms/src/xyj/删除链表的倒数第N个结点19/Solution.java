package xyj.ɾ������ĵ�����N�����19;


//Definition for singly-linked list.


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
    // ˫ָ����Խ��
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode front = head,back = head;
        for (int i = 0; i < n - 1; i++) {
            front = front.next;
        }
        ListNode temp = null;
        while (front.next!=null){
            front = front.next;
            temp = back;
            back = back.next;
        }
        if (temp == null){
            return head.next;
        }else if(front == back) {
            temp.next = null;
        }else{
            temp.next = back.next;
        }
        return head;
    }

    //public static void main(String[] args) {
    //    //���룺head = [1,2,3,4,5], n = 2
    //    //�����[1,2,3,5]
    //
    //}
}
