package xyj.缺失的第一个正数41;
//重点： 缺失的正数一定是在[1,L+1]之间
public class Solution {
    public int firstMissingPositive(int[] nums) {
        int L = nums.length;
        for (int i = 0; i < L; i++) {
            if (nums[i]<=0){
                nums[i] = L+1;
            }
        }
        for (int i = 0; i < L; i++) {
            int a = Math.abs(nums[i]);
            if (a <= L){
                // 这里加绝对值 是因为数组有重复数字
                nums[ a-1 ] = - Math.abs(nums[a-1]);
            }
        }
        for (int i = 0; i < L; i++) {
            if (nums[i]>0){
                return i+1;
            }
        }
        return L+1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,6,3,5,4};
        int i = solution.firstMissingPositive(nums);
        System.out.println(i);

    }
}
