package xyj.合并K个升序链表23;

// 多指针解决
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

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0){
            return null;
        }
        int t=0;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i]==null){
                t++;
            }
        }
        if (t == lists.length){
            return null;
        }
        ListNode head = new ListNode(0);
        ListNode pp = head;
        ListNode temp = null;
        while (true){
            int min = 100000;
            int index = 0,flag=0;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i]!=null ){
                    if (lists[i].val < min){
                        temp = lists[i];
                        min = lists[i].val;
                        index = i;
                    }
                }else {
                    flag ++;
                }
            }
            pp.next = temp;
            pp = pp.next;
            lists[index] = lists[index].next;
            if (flag == lists.length - 1){
                break;
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);
        node.next = node1;
        node1.next = node2;

        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        node3.next = node4;
        node4.next = node5;

        ListNode node6 = new ListNode(2);
        ListNode node7 = new ListNode(6);
        node6.next = node7;

        Solution solution = new Solution();
        ListNode[] listNodes = new ListNode[3];
        listNodes[0] = null;
        listNodes[1] = null;
        listNodes[2] = null;
        solution.mergeKLists(listNodes);


    }
}
