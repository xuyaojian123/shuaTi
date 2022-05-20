import  math

class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        start, end = 0, len(nums) - 1
        while start <= end:
            # mid = start + (start - end) // 2 #可以防止start + end（超出整数范围）
            mid = (start + end) // 2
            if nums[mid] < target:
                start = mid + 1
            elif nums[mid] > target:
                end = mid - 1
            else:
                return mid
        return -1


t = Solution()
nums = [-1, 0, 3, 5, 9, 12]
target = 23
result = t.search(nums,target)
print(result)
