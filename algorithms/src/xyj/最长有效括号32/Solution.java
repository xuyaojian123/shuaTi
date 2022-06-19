package xyj.最长有效括号32;

import java.util.Arrays;

public class Solution {

    // 动态规划 dp[i]表示以i为结尾的合法最长有效括号子串的长度。
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int max = 0;
        for (int i = 1; i < dp.length; i++) {
            // 只有当是s[i]=')'才能匹配,是s[i]='('肯定为0
            if (s.charAt(i) == ')'){
                if (s.charAt(i-1) == '('){
                    dp[i] = (i>=2 ? dp[i-2]:0) + 2;
                }else if ((i-dp[i-1] > 0) && (s.charAt(i - dp[i-1] - 1)=='(')){
                    dp[i] = dp[i-1] + dp[(Math.max(i - dp[i - 1] - 2, 0))] + 2;
                }
            }
            if (dp[i]>max){
                max = dp[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        String s = "(()())";
        int i = solution.longestValidParentheses(s);
        System.out.println(i);
    }
}
