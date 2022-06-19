package xyj.���Ч����32;

import java.util.Arrays;

public class Solution {

    // ��̬�滮 dp[i]��ʾ��iΪ��β�ĺϷ����Ч�����Ӵ��ĳ��ȡ�
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int max = 0;
        for (int i = 1; i < dp.length; i++) {
            // ֻ�е���s[i]=')'����ƥ��,��s[i]='('�϶�Ϊ0
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
