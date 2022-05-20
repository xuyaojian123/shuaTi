#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
@File  : main.py
@Author: XuYaoJian
@Date  : 2022/2/28 15:48
@Desc  : 
"""
from typing import List

"""
    二分查找
    在数组中找到两个数，使得它们的和等于目标值，可以首先固定第一个数，然后寻找第二个数，第二个数等于目标值减去第一个数的差。利用数组的有序性质，可以通过二分查找的方法寻找第二个数。
    为了避免重复寻找，在寻找第二个数时，只在第一个数的右侧寻找
"""


class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        left, right = 0, len(numbers)-1
        while left < right:
            sum = numbers[left] + numbers[right]
            if sum < target:
                left+=1
            elif sum > target:
                right-=1
            else:
                return list([left+1, right+1])
        return None


if __name__ == "__main__":
    pass
