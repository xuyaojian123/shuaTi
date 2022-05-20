#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
@File  : main.py
@Author: XuYaoJian
@Date  : 2021/12/6 21:46
@Desc  : 
"""
from typing import List


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [float("inf")] * (amount + 1)
        # base case
        dp[0] = 0
        for i in range(0, len(dp)):
            for coin in coins:
                if (i - coin) < 0:
                    continue
                dp[i] = min(dp[i], 1 + dp[i - coin])
        if dp[amount] == float("inf"):
            return -1
        else:
            return dp[amount]


if __name__ == "__main__":
    # coins = [1, 2, 5]
    # amount = 11
    coins = [2]
    amount = 3
    s = Solution()
    num = s.coinChange(coins, amount)
    print(num)
