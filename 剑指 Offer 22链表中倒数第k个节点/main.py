#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
@File  : main.py
@Author: XuYaoJian
@Date  : 2022/2/28 15:29
@Desc  : 
"""


# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def getKthFromEnd(self, head: ListNode, k: int) -> ListNode:
        behind, front = head, head
        for x in range(k):
            front = front.next
        while front:
            behind = behind.next
            front = front.next
        return behind


if __name__ == "__main__":
    pass
