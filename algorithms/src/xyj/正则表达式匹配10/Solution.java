package xyj.正则表达式匹配10;

public class Solution {

    public boolean isMatch(String s, String p) {
        // dp[i][j]代表p的前i个字符和s的前j个字符能否匹配
        int m = s.length(),n = p.length();
        s = " " + s;
        p = " " + p;
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0]= true;
        for (int i = 1; i < n+1; i++) {
            if(p.charAt(i) == '*'){
                if (i - 2 >=0){
                    dp[i][0] = dp[i - 2][0]; // 可以把p的*号和前面的字符一起去除
                }
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m+1; j++) {
                // 分三种情况
                if ( p.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i-1][j-1];
                }else if (p.charAt(i)=='.'){
                    dp[i][j] = dp[i-1][j-1];
                }else if( p.charAt(i)=='*'){
                    // p的前一个字符不能够匹配到s的当前字符或者不去匹配，两种选择(删除前面的字符和*号，也就是i-2)
                    dp[i][j] = dp[i-2][j];
                    // 如果p的前一个字符能够匹配到s的当前字符
                    // (如果匹配的话，这里要使用完全背包的优化的思想。因为可能有无穷多个，我们只考虑当前这个j被匹配的情况。)
                    if (p.charAt(i-1)==s.charAt(j) || p.charAt(i-1) =='.'){
                        dp[i][j] = dp[i][j-1] || dp[i][j]; // 这里要用或，对应前面两种选择
                    }
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String a = "aaa";
        String b = "ab*a*c*a";
        boolean match = solution.isMatch(a, b);
        System.out.println(match);
    }
}
