package xyj.Ðý×ªÁ´±í61;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        //ListNode listNode4 = new ListNode(4);
        //ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        //listNode3.next = listNode4;
        //listNode4.next = listNode5;
        solution.rotateRight(listNode1,4);


    }


    public ListNode rotateRight(ListNode head, int k) {
        if (head==null){
            return null;
        }

        List<Integer> storage = new LinkedList<>();
        ListNode after = head;
        ListNode front = head;
        int total = 0;
        for (int i = 0; i < k; i++) {
            storage.add(after.val);
            after = after.next;
            total++;
            if (after == null){
                storage.clear();
                after = head;
                k = k%total;
                i = -1;
            }
        }
        while (after!=null){
            storage.add(after.val);
            after.val = storage.get(0);
            storage.remove(0);
            after = after.next;
        }
        for (int i = 0; i < storage.size(); i++) {
            front.val = storage.get(i);
            front = front.next;
        }
        return head;
    }
}



class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}