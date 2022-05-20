 package xyj.两数相加2;


 //* Definition for singly-linked list.
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int setp = 0;
        ListNode head = new ListNode();
        ListNode temp = head;
        while (l1!=null && l2!=null){
            ListNode node = new ListNode();
            int value1 = l1.val;
            int value2 = l2.val;
            int t = value1 + value2 + setp;
            int val = t %10;
            if (t >= 10){
                setp = 1;
            }
            else {
                setp = 0;
            }
            node.val = val;
            temp.next = node;
            temp = temp.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if( l1 == null && l2 ==null && setp == 1){
            temp.next = new ListNode(1);
            temp = temp.next;
        }
        if (setp == 1){
            if (l1 == null){
                temp.next = l2;
                ListNode flag = new ListNode();
                while (l2!=null){
                    int value2 = l2.val;
                    int t =  value2 + setp;
                    int val = t %10;
                    if (t >= 10){
                        setp = 1;
                    }
                    else {
                        setp = 0;
                    }
                    flag = l2;
                    l2.val = val;
                    l2 = l2.next;
                }
                if (setp == 1){
                    ListNode node = new ListNode();
                    node.val = 1;
                    flag.next = node;
                }
            }else {
                temp.next = l1;
                ListNode flag = new ListNode();
                while (l1!=null){
                    int value1 = l1.val;
                    int t =  value1 + setp;
                    int val = t %10;
                    if (t >= 10){
                        setp = 1;
                    }
                    else {
                        setp = 0;
                    }
                    flag = l1;
                    l1.val = val;
                    l1 = l1.next;
                }
                if (setp == 1){
                    ListNode node = new ListNode();
                    node.val = 1;
                    flag.next = node;
                }
            }
        }else {
            if (l1 == null){
                temp.next = l2;
            }else {
                temp.next = l1;
            }
        }
        print(head.next);
        return head.next;
    }

    public void print(ListNode node){
        while (node!=null){
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        //l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
        ListNode listNode1 = new ListNode(9);
        ListNode listNode2 = new ListNode(9);
        ListNode listNode3 = new ListNode(9);
        ListNode listNode4 = new ListNode(9);
        ListNode listNode5 = new ListNode(9);
        ListNode listNode6 = new ListNode(9);
        ListNode listNode7 = new ListNode(9);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;



        ListNode listNode8 = new ListNode(9);
        ListNode listNode9 = new ListNode(9);
        ListNode listNode10 = new ListNode(9);
        ListNode listNode11= new ListNode(9);
        listNode8.next = listNode9;
        listNode9.next = listNode10;
        listNode10.next = listNode11;
        Solution solution = new Solution();
        ListNode listNode = solution.addTwoNumbers(listNode1, listNode8);

    }
}
