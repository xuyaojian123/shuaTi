#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
@File  : main.py
@Author: XuYaoJian
@Date  : 2022/1/2 21:12
@Desc  : 
"""
from typing import List


class Solution:

    def permute(self, nums: List[int]) -> List[List[int]]:

        result = []

        def backtrack(t):
            if t >= len(nums):
                result.append(nums[:])

            for i in range(t, len(nums)):
                swap(t, i)
                backtrack(t + 1)
                swap(t, i)

        def swap(a, b):
            temp = nums[a]
            nums[a] = nums[b]
            nums[b] = temp

        backtrack(0)
        print(result)
        return result



if __name__ == "__main__":
    nums = [1, 2, 3]
    s = Solution()
    s.permute(nums=nums)
