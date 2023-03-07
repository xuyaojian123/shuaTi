package xyj.最大子数组和53;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = {-2,1,-3,4,-1,2,1,-5,4};
        int i = solution.maxSubArray(ints);
        System.out.println(i);

    }

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i-1]>0){
                dp[i] = dp[i-1] + nums[i];
            }else {
                dp[i] = nums[i];
            }
        }
        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            if (dp[i]>max){
                max = dp[i];
            }
        }
        return max;
    }
}
