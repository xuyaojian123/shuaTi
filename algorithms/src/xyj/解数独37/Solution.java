package xyj.解数独37;

import java.util.HashMap;

public class Solution {

    // 三个布尔数组 表明 行, 列, 还有 3*3 的方格的数字是否被使用过
    boolean[][] rowUsed = new boolean[9][10];
    boolean[][] colUsed = new boolean[9][10];
    boolean[][][] boxUsed = new boolean[3][3][10];
    private boolean valid = false;
    // 排序树
    public void solveSudoku(char[][] board) {
        // 初始化
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[0].length; col++) {
                int num = board[row][col] - '0';
                if(1 <= num && num <= 9){
                    rowUsed[row][num] = colUsed[col][num] = boxUsed[row/3][col/3][num] = true;
                }
            }
        }
        // 递归尝试填充数组
        dfs(board, 0, 0);
        int a = 1;
    }

    public boolean dfs(char[][] board,int row,int col){
        if (col == 9) {
            col = 0;
            row++;
            if (row == 9){
                return true;
            }
        }
        if (board[row][col]=='.'){
            for (int i = 1; i <= 9; i++) {
                boolean canUsed = !(rowUsed[row][i] || colUsed[col][i] || boxUsed[row/3][col/3][i]);
                if ( canUsed ){
                    rowUsed[row][i] = colUsed[col][i] = boxUsed[row/3][col/3][i] = true;
                    board[row][col] = (char) ('0'+i);
                    if (dfs(board, row, col+1)){
                        return true;
                    }
                    board[row][col] = '.';
                    rowUsed[row][i] = colUsed[col][i] = boxUsed[row/3][col/3][i] = false;
                }
            }
        }else {
            return dfs(board, row, col + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        Solution solution = new Solution();
        solution.solveSudoku(board);
    }
}
