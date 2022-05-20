#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
@File  : main.py
@Author: XuYaoJian
@Date  : 2022/2/28 15:18
@Desc  : 
"""


# Definition for singly-linked list.
from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def middleNode(self, head: Optional[ListNode]) -> ListNode:
        front, behind = head, head
        while front and front.next:
            behind = behind.next
            front = front.next.next
        return behind

if __name__ == "__main__":
    pass
