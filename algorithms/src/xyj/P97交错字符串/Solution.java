package xyj.P97交错字符串;

public class Solution {

    public static void main(String[] args) {

    }

    // https://leetcode.cn/problems/interleaving-string/solution/dong-tai-gui-hua-zhu-xing-jie-shi-python3-by-zhu-3/
    // 动态规划方法
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), t = s3.length();
        if (n + m != t){
            return false;
        }
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;
        // 初始化第一列dp[i][0] // 为什么相等时候需要i-1,因为表示索引位置，循环表示长度
        for (int i = 1; i <= n ; i++) {
            dp[i][0] = dp[i-1][0] && (s1.charAt(i-1) == s3.charAt(i-1));
        }
        // 初始化第一行dp[0][j]
        for (int j = 1; j <= m; j++) {
            dp[0][j] = dp[0][j-1] && (s2.charAt(j-1) == s3.charAt(j-1));
        }
        // 整体dp
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int p = i + j - 1; // s3最后一个字符的索引（比如i=1,j=1,i+j=2，表示s3长度为2的字符串，那么索引p就等于1）
                if (s1.charAt(i-1) == s3.charAt(p)){
                    dp[i][j] = dp[i][j] || dp[i-1][j];
                }
                if (s2.charAt(j-1) == s3.charAt(p)){
                    dp[i][j] = dp[i][j] || dp[i][j-1];
                }
            }
        }
        return dp[n][m];
    }

    // dfs搜索方法
    int l1, l2, l3;
    boolean[][] visited = null;
    String s1, s2, s3;
    public boolean isInterleave_1(String s1, String s2, String s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        l1 = s1.length();
        l2 = s2.length();
        l3 = s3.length();
        if(l1 + l2 != l3){
            return false;
        }
        visited = new boolean[l1 + 1][l2 + 1];
        return dfs(0, 0, 0);


    }
    public boolean dfs(int i, int j, int k){
        if(k == l3){
            return true;
        }
        if(visited[i][j]){
            return false;
        }
        visited[i][j] = true;
        if(i < l1 && s1.charAt(i) == s3.charAt(k) && dfs(i + 1, j, k + 1)){
            return true;
        }
        if(j < l2 && s2.charAt(j) == s3.charAt(k) && dfs(i, j + 1, k + 1)){
            return true;
        }
        return false;
    }



    // 递归遍历
    public boolean isInterleave_2(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        boolean[][] memo=new boolean[s1.length()+1][s2.length()+1];//boolean数组默认为false;
        return dfs(0,0,0,s1,s2,s3,memo);
    }
    public boolean dfs(int ix1, int ix2, int ix3, String s1, String s2, String s3, boolean[][] memo){
        if(ix3 >= s3.length()) return true;
        if(memo[ix1][ix2]) return false;
        if(ix1 < s1.length() && s1.charAt(ix1) == s3.charAt(ix3)){
            if(dfs(ix1+1,ix2,ix3+1,s1,s2,s3,memo)){
                return true;
            }
        }
        if(ix2 < s2.length() && s2.charAt(ix2) == s3.charAt(ix3)){
            if(dfs(ix1,ix2+1,ix3+1,s1,s2,s3,memo)){
                return true;
            }
        }
        memo[ix1][ix2]=true;//代表从s1的ix1下标与s2的ix2下标开始，后面所有的组合均已遍历，均不匹配
        return false;
    }
}
