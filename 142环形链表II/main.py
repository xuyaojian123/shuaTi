#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
@File  : main.py
@Author: XuYaoJian
@Date  : 2022/2/27 20:09
@Desc  : 
"""


# Definition for singly-linked list.
from typing import Optional


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def detectCycle(self, head: Optional[ListNode]) -> ListNode:
        s = {}
        pos = -1
        while head:
            if head in s:
                value = s[head]
                # return value
                return head
            pos += 1
            s[head] = pos
            head = head.next
        return None


if __name__ == "__main__":
    a = ListNode(1)
    b = ListNode(2)
    c = ListNode(3)
    d = ListNode(3)
    a.next = b
    b.next = c
    c.next = d
    d.next = b
    s = Solution()
    print(s.detectCycle(a))
