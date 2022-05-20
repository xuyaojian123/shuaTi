#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
@File  : main.py
@Author: XuYaoJian
@Date  : 2022/2/26 22:37
@Desc  : 
"""

# Definition for singly-linked list.
from typing import Optional


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


# 利用对象的内存地址是唯一，如果有环的话那么一定重复过对象，
# 把到过的对象地址放在set集合中
class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        s = set()
        while head:
            memory_address = int(id(head))
            if memory_address in s:
                return True
            s.add(memory_address)
            head = head.next
        return False


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
    print(s.hasCycle(a))

