#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
@File  : main.py
@Author: XuYaoJian
@Date  : 2021/11/14 17:24
@Desc  : 
"""
"""
    point:对于二叉树中的一个节点，该节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值，如果子节点的最大贡献值为正，则计入该节点的最大路径和，否则不计入该节点的最大路径和。
"""
from typing import Optional

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution(object):
    def __init__(self):
        self.maxSum = float("-inf")

    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        self.maxGain(root)
        return self.maxSum

    def maxGain(self, root):
        if root is None:
            return 0
        left = max(0, self.maxGain(root.left))
        right = max(0, self.maxGain(root.right))
        self.maxSum = max(self.maxSum, left + right + root.val)
        print(str(left) + " " + str(right) + " ", end="")
        print(left + right + root.val)
        return max(left, right) + root.val

if __name__ == "__main__":
    t = TreeNode(-1)
    t1 = TreeNode(-9)
    t2 = TreeNode(-20)
    t3 = TreeNode(-15)
    t4 = TreeNode(-70)
    t.left = t1
    t.right = t2
    t2.left = t3
    t2.right = t4

    s = Solution()
    k = s.maxPathSum(t)
    print(k)
