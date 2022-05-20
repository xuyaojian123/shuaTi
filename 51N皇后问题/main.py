#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
@File  : main.py
@Author: XuYaoJian
@Date  : 2022/2/11 23:24
@Desc  : 
"""
from typing import List


# 使用排序树解决
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        position = [i for i in range(n)]

        result = list()
        def backtrack(param):
            # 结束条件
            if param == n:
                result.append(position[:])
            else:
                for i in range(param, n):
                    swap(param, i)
                    if check(param):
                        backtrack(param + 1)
                    swap(param, i)

        def swap(i, j):
            t = position[i]
            position[i] = position[j]
            position[j] = t

        def check(param):
            # 不在同一列，以及在不同对角线上
            for i in range(param):
                if position[param] == position[i] or abs(param - i) == abs(position[param] - position[i]):
                    return False
            return True

        backtrack(0)
        final_result = list()
        for i in range(len(result)):
            temp = list()
            for j in range(n):
                Str = ['.' for _ in range(n)]
                Str[result[i][j]] = 'Q'
                temp.append("".join(Str))
            final_result.append(temp)
        return final_result


if __name__ == "__main__":
    s = Solution()
    result = s.solveNQueens(4)
    print(result)
