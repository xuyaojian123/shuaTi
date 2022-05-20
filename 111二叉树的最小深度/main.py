#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
@File  : main.py
@Author: XuYaoJian
@Date  : 2022/2/12 16:38
@Desc  :
"""

# BFS模板题
# Definition for a binary tree node.
import queue
from collections import deque


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:

    def minDepth(self, root: TreeNode) -> int:
        if root is None:
            return 0
        q = queue.Queue()
        q.put(root)
        high = 1
        while not q.empty():
            size = q.qsize()
            for i in range(size):
                node = q.get()
                node_left = node.left
                node_right = node.right
                if node_left is None and node_right is None:
                    return high
                else:
                    if node_left is not None:
                        q.put(node_left)
                    if node_right is not None:
                        q.put(node_right)
            high = high + 1


if __name__ == "__main__":
    s = Solution()
    root1 = TreeNode(3)
    root2 = TreeNode(9)
    root3 = TreeNode(20)
    root4 = TreeNode(15)
    root5 = TreeNode(17)
    root1.left = root2
    root1.right = root3
    root3.left = root4
    root3.right = root5
    high = s.minDepth(root1)
    print(high)

