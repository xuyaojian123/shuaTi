#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
@File  : main.py
@Author: XuYaoJian
@Date  : 2022/2/22 15:07
@Desc  : BFS解题
"""
from typing import List
import queue


class Solution:
    def openLock(self, deadends: List[str], target: str) -> int:
        start = "0000"
        if start in deadends:
            return -1
        # 已经到过的密码
        visit = set()
        visit.add(start)
        # 不能到达的密码
        dead = set(deadends)

        def BFS():
            num = 0
            q = queue.Queue()
            q.put(start)
            while not q.empty():
                size = q.qsize()
                # 将当前队列中的所有节点向周围扩散
                for i in range(size):
                    temp = q.get()
                    if temp == target:
                        return num
                    else:
                        for x in range(4):
                            up = self.up(temp, x)
                            down = self.down(temp, x)
                            if not (up in visit) and not (up in dead):
                                q.put(up)
                                visit.add(up)
                            if not (down in visit) and not (down in dead):
                                q.put(down)
                                visit.add(down)

                num = num + 1
            return -1

        # 双向BFS
        def bidirectional_BFS():
            q1 = set()
            q2 = set()
            q1.add(start)
            q2.add(target)
            ans = 0
            while len(q1) != 0 and len(q2) != 0:
                temp = set()
                for x in q1:
                    if x in q2:
                        # return step + x[1]
                        return ans
                    visit.add(x) # visit.add(x)只能放在这里，不能放在下面
                    # 将一个节点的未遍历相邻节点加入集合
                    for j in range(4):
                        up = self.up(x, j)
                        down = self.down(x, j)
                        if not (up in visit) and not (up in dead):
                            temp.add(up)
                            # visit.add(up)
                        if not (down in visit) and not (down in dead):
                            temp.add(down)
                            # visit.add(down)

                ans += 1
                q1 = q2
                q2 = temp

            return -1

        # num = BFS()
        num = bidirectional_BFS()
        return num

    # 密码中第index位置向上波动
    def up(self, password: str, index: int):
        if password[index] == '9':
            password = password[:index] + '0' + password[index + 1:]
        else:
            password = password[:index] + chr(ord(password[index]) + 1) + password[index + 1:]
        return password

    # 密码中第index位置向下波动
    def down(self, password: str, index: int):
        if password[index] == '0':
            password = password[:index] + '9' + password[index + 1:]
        else:
            password = password[:index] + chr(ord(password[index]) - 1) + password[index + 1:]
        return password


if __name__ == "__main__":
    deadends, target = ["0201", "0101", "0102", "1212", "2002"], "0202"
    # deadends = ["8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"]
    # target = "8888"
    # deadends = ["8888"]
    # target = "0009"
    s = Solution()
    num = s.openLock(deadends, target)
    print(num)
