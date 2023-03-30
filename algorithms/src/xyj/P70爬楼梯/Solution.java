package xyj.P70ÅÀÂ¥Ìİ;

public class Solution {

    public static void main(String[] args) {


    }



    public int climbStairs(int n) {
        int[] dp = new int[46];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

}
