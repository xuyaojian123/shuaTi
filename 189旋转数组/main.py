#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
@File  : main.py
@Author: XuYaoJian
@Date  : 2021/9/26 9:49
@Desc  :  给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
"""
from copy import copy


class Solution(object):
    # 第一种方法（开辟了另外一个数组空间）
    def rotate1(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        other = copy(nums)
        L = len(nums)
        for idx, content in enumerate(nums):
            other[(idx + k) % L] = content
        for idx, o in enumerate(other):
            nums[idx] = o

    # 方法二：数组翻转
    def rotate2(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        k %= len(nums)
        # 1、反转全部数组
        self.reverse(nums, 0, len(nums) - 1)
        self.reverse(nums, 0, k - 1)
        self.reverse(nums, k, len(nums) - 1)


    # 反转数组中指定的位置，在原数组操作
    def reverse(self, nums, start, end):
        while start < end:
            temp = nums[start]
            nums[start] = nums[end]
            nums[end] = temp
            start += 1
            end -= 1

if __name__ == "__main__":
    s = Solution()
    # nums = [1,2,3,4,5,6,7]
    # k = 3
    nums = [-1, -100, 3, 99]
    k = 2
    t = s.rotate1(nums, k)
    print(t)
    print(nums)
