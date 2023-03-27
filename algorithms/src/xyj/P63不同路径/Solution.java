package xyj.P63不同路径;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] obstacleGrid =  {{0,0,0},{0,1,0},{0,0,0}};
        int i = solution.uniquePathsWithObstacles(obstacleGrid);
        System.out.println(i);

    }


    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] record = new int[m][n];
        int dfs = dfs(0, 0, m, n, record, obstacleGrid);
        return dfs;

    }

    // dp方法
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m ; i++) {
            if (obstacleGrid[i][0]==0){
                dp[i][0] = 1;
            }else {
                break;
            }
        }
        for (int i = 0; i < n ; i++) {
            if (obstacleGrid[0][i]==0){
                dp[0][i] = 1;
            }else {
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j]!=1){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }

    public int dfs(int i , int j, int m, int n, int[][] record,int[][] obstacleGrid){
        if (obstacleGrid[i][j] == 1){
            return 0;
        }
        if (i==m-1 && j == n-1){
            return 1;
        }
        if (record[i][j]!=0){
            return record[i][j];
        }
        int ans = 0;
        // 向右
        if (j + 1 < n && obstacleGrid[i][j+1] != 1){
            ans += dfs(i, j+1, m, n, record,obstacleGrid);
        }
        // 向下
        if (i + 1 < m && obstacleGrid[i+1][j] != 1){
            ans += dfs(i+1, j, m, n, record,obstacleGrid);
        }
        record[i][j] = ans;
        return record[i][j];
    }
}
