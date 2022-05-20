#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
@File  : main.py
@Author: XuYaoJian
@Date  : 2021/11/2 14:47
@Desc  : 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
"""
from typing import List


class Solution(object):

    def canPartition(self, nums: List[int]) -> bool:
        if len(nums) == 1:
            return False
        if sum(nums) % 2 == 1:
            return False
        summ = sum(nums)
        dic_sum = dict()

        def dfs(sum_1, index):
            if sum_1 in dic_sum:
                return dic_sum[sum_1]
            if sum_1 > summ / 2 or (sum_1!= summ/2 and index >= len(nums)):
                dic_sum[sum_1] = False
                return False
            if sum_1 == summ / 2:
                dic_sum[sum_1] = True
                return True
            result = dfs(sum_1 + nums[index], index + 1) or dfs(sum_1, index + 1)
            return result
        return dfs(0, 0)


if __name__ == "__main__":
    S = Solution()
    nums = [1,5,11,5]
    t = S.canPartition(nums=nums)
    print(t)
