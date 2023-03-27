package xyj.P64最小路径和;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {{9,1,4,8}};
        int i = solution.minPathSum1(grid);
        System.out.println(i);
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = grid[i][0] + dp[i-1][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = grid[0][i] + dp[0][i-1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i-1][j]+grid[i][j],dp[i][j-1]+grid[i][j]);
            }
        }
        return dp[m-1][n-1];
    }

    //dfs + 记忆
    public int minPathSum1(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        int[][] memo = new int[M][N];
        for (int i = 0; i < M; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs1(grid,M,N, 0, 0,memo);
    }


    public int dfs(int[][] grid,int M,int N, int r, int c,int[][] memo) {
        //若越界，则认为不可达，距离为无穷大
        if (r < 0 || r >= M || c < 0 || c >= N) return Integer.MAX_VALUE;
        if (memo[r][c] > -1) return memo[r][c];
        //若到达终点，终点的贡献值是其本身
        if (r == M - 1 && c== N - 1) return grid[M - 1][N - 1];
        //右边的点到终点最短的路径
        int right = dfs(grid,M,N, r, c + 1,memo);
        //下面的点到终点的最短路径
        int down = dfs(grid,M,N, r + 1, c,memo);
        //取两者的较小值，计算出当前点的最小路径值
        int ans = Math.min(right, down) + grid[r][c];
        memo[r][c] = ans;
        return ans;
    }

    public int dfs1(int[][] grid,int M,int N, int i, int j,int[][] memo) {
       if (memo[i][j]>-1){
           return memo[i][j];
       }
       if (i==M-1 && j == N-1){
           return grid[i][j];
       }
       int right = Integer.MAX_VALUE;
       if (j+1<N){
            right = dfs1(grid,M,N, i,j+1,memo);
       }
       int down = Integer.MAX_VALUE;
       if (i+1<M){
           down = dfs1(grid,M,N, i+1,j,memo);
       }
       //取两者的较小值，计算出当前点的最小路径值
       int ans = Math.min(right, down) + grid[i][j];
       memo[i][j] = ans;
       return memo[i][j];
    }

}
