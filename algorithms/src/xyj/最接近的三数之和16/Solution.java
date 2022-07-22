package xyj.最接近的三数之和16;

import java.util.Arrays;

public class Solution {

    public int threeSumClosest(int[] nums, int target) {
        int result = Integer.MAX_VALUE;
        int res = 0;
        //先排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int close = twoSumClosest(nums, i + 1, target - nums[i]) + nums[i];
            if (close == target){
                return target;
            }else {
                if ( Math.abs(target - close) < result ){
                    result = Math.abs(target - close);
                    res = close;
                }
            }

        }
        return res;
    }

    public int twoSumClosest(int[] nums , int start,int target){
        int min = Integer.MAX_VALUE;
        int result = 0;
        int left = start;
        int right = nums.length - 1;
        while (left < right){
            int sum = nums[left] + nums[right];
            int error = Math.abs(target - sum);
            if (error < min){
                min = error;
                result = sum;
            }
            if (sum < target){
                left++;
            }else if (sum > target){
                right--;
            }else {
                return target;
            }
        }
        return result;
    }

    

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = {-1,2,1,-4};
        int target = 1;
        //Arrays.sort(ints);
        int i = solution.threeSumClosest(ints,target);
        System.out.println(i);
    }
}
