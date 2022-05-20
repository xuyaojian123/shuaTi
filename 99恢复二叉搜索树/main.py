#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
@File  : main.py
@Author: XuYaoJian
@Date  : 2021/12/6 14:46
@Desc  : 
"""


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


from typing import Optional


class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        values = []

        def inorder_traversal(root: Optional[TreeNode]):
            if not root:
                return
            inorder_traversal(root.left)
            values.append(root)
            inorder_traversal(root.right)

        inorder_traversal(root)
        pre_node = values[0]
        x, y = None, None
        for i in range(1, len(values)):
            if pre_node.val > values[i].val:
                y = values[i]
                if not x:
                    x = pre_node
            pre_node = values[i]
        if x and y:
            x.val, y.val = y.val, x.val


if __name__ == "__main__":
    root1 = TreeNode(1)
    root3 = TreeNode(2)
    root2 = TreeNode(4,left=root3)
    root = TreeNode(3,left=root1,right=root2)
    s = Solution()
    s.recoverTree(root)
    print(root.val)

