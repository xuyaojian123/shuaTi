package xyj.P6433矩阵中移动的最大次数;

public class Solution {

    public static void main(String[] args) {
        int[][] grid = {
                {1000000,92910,1021,1022,1023,1024,1025,1026,1027,1028,1029,1030,1031,1032,1033,1034,1035,1036,1037,1038,1039,1040,1041,1042,1043,1044,1045,1046,1047,1048,1049,1050,1051,1052,1053,1054,1055,1056,1057,1058,1059,1060,1061,1062,1063,1064,1065,1066,1067,1068},
                {1069,1070,1071,1072,1073,1074,1075,1076,1077,1078,1079,1080,1081,1082,1083,1084,1085,1086,1087,1088,1089,1090,1091,1092,1093,1094,1095,1096,1097,1098,1099,1100,1101,1102,1103,1104,1105,1106,1107,1108,1109,1110,1111,1112,1113,1114,1115,1116,1117,1118}
        };
        //System.out.println(grid[0].length);50
        Solution solution = new Solution();
        int i = solution.maxMoves(grid);
        System.out.println(i);


    }
    int[][] dir = {{-1,1},{0,1},{1,1}};

    public int maxMoves(int[][] grid) {
        int[][] memo = new int[grid.length][grid[0].length];
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            ans = Math.max(ans,dfs(i,0,grid,memo));
        }
        return ans;
    }

    // 记忆化搜索
    public int dfs(int i, int j, int[][] grid,int[][] memo){
        if (memo[i][j]!=0){
            return memo[i][j];
        }
        int ans =0;
        for (int k = 0; k < dir.length; k++) {
            int x = i + dir[k][0];
            int y = j + dir[k][1];
            if ( x<0 || x > grid.length-1 || y> grid[0].length-1 ){
                continue;
            }
            int value = grid[x][y];
            if (value > grid[i][j]){
                ans = Math.max(ans,dfs(x, y , grid , memo) + 1);
            }
        }
        memo[i][j] = ans;
        return ans;
    }
}
