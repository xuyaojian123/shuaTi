#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
@File  : main.py
@Author: XuYaoJian
@Date  : 2021/11/15 22:42
@Desc  : 
"""
# Definition for a binary tree node.
from typing import List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        inMap = {value: idx for idx, value in enumerate(inorder)}
        pre_end = len(preorder) - 1
        in_end = len(inorder) - 1
        def buildTree(pre_start, pre_end, in_start, in_end):
            """
            :param pre_start:前序遍历中的 树的左边界下标
            :param pre_end: 前序遍历中的 树的右边界下标
            :param in_start: 中序遍历中的 树的左边界下标
            :param in_end: 中序遍历中的 树的右边界下标
            :return:
            """
            if pre_start > pre_end:
                return None
            root = TreeNode(preorder[pre_start])
            index = inMap[root.val]
            nums = index - in_start
            # 左子树
            root.left = buildTree(pre_start+1 , nums + pre_start, in_start, index-1)
            # 右子树
            root.right = buildTree(nums+pre_start+1, pre_end, index+1, in_end)
            return root
        root = buildTree(0, pre_end, 0, in_end)
        return root

if __name__ == "__main__":
    s = Solution()
    preorder = [3, 9, 20, 15, 7]
    inorder = [9, 3, 15, 20, 7]
    root = s.buildTree(preorder, inorder)
    print(root.val)

