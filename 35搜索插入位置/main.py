#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
@File  : main.py
@Author: XuYaoJian
@Date  : 2021/9/24 21:45
@Desc  :
        给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
        请必须使用时间复杂度为 O(log n) 的算法。
        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/search-insert-position
"""


class Solution(object):
    def search_insert(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        start, end = 0, len(nums) - 1
        while start <= end:
            mid = start + (end - start) // 2
            if target < nums[mid]:
                end = mid-1
            elif target > nums[mid]:
                start = mid + 1
            else:
                return mid
        return start


if __name__ == "__main__":
    pass
