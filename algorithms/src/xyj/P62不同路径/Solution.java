package xyj.P62不同路径;

public class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.uniquePaths(3, 2);
        System.out.println(i);

    }

    public int uniquePaths(int m, int n) {
        int[][] record = new int[m+1][n+1];
        int count = dfs(1, 1, m, n, record);
        return count;
    }


    public int dfs(int i , int j, int m, int n, int[][] record){
        if (i==m && j == n){
            return 1;
        }
        if (record[i][j]!=0){
            return record[i][j];
        }
        int ans = 0;
        // 向右
        if (j + 1 <= n){
            ans += dfs(i, j+1, m, n, record);
        }
        // 向下
        if (i + 1 <= m){
            ans += dfs(i+1, j, m, n, record);
        }
        record[i][j] = ans;
        return record[i][j] ;
    }
}
