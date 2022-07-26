package xyj.有效的数独36;

import java.util.HashMap;

public class Solution {

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i <= board.length - 3; i+=3) {
            for (int j = 0; j <= board.length - 3; j+=3) {
                HashMap<Character, Integer> mapping = new HashMap<>();
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (board[i + k][j + l] != '.' && mapping.containsKey(board[i + k][j + l])) {
                            return false;
                        } else {
                            mapping.put(board[i + k][j + l], 1);
                        }
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            HashMap<Character, Integer> mapping = new HashMap<>();
            HashMap<Character, Integer> mapping2 = new HashMap<>();
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.' && mapping.containsKey(board[i][j])) {
                    return false;
                } else {
                    mapping.put(board[i][j], 1);
                }
                if (board[j][i] != '.' && mapping2.containsKey(board[j][i])) {
                    return false;
                } else {
                    mapping2.put(board[j][i], 1);
                }
            }
        }
        return true;
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
        boolean validSudoku = solution.isValidSudoku(board);
        System.out.println(validSudoku);

    }
}
