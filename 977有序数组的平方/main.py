#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
@File  : main.py
@Author: XuYaoJian
@Date  : 2021/9/24 22:22
@Desc  :
    给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
"""


class Solution(object):

    def sortedSquares(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        nums.sort(key=abs, reverse=False)
        result = [x * x for x in nums]
        return result

    def sortedSquares1(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        result = [x * x for x in nums]
        self.quick_sort(result, 0, len(nums) - 1)
        return result

    # 快速排序
    def quick_sort(self, lists, i, j):
        if i >= j:
            return list
        pivot = lists[i]
        low = i
        high = j
        while i < j:
            while i < j and lists[j] >= pivot:
                j -= 1
            lists[i] = lists[j]
            while i < j and lists[i] <= pivot:
                i += 1
            lists[j] = lists[i]
        lists[j] = pivot
        self.quick_sort(lists, low, i - 1)
        self.quick_sort(lists, i + 1, high)
        return lists


if __name__ == "__main__":
    s = Solution()
    t = [7, 5, 1]
    s.sortedSquares(t)
    print(t)
    pass
