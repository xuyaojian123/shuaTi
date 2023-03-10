package xyj.螺旋矩阵54;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int matrix[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> integers = solution.spiralOrder(matrix);

    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int i=0,j=0;
        int row1 = 0;
        int column1 = 0;
        int row = matrix.length;
        int column = matrix[0].length;
        List<Integer> results = new ArrayList<>();
        while ( results.size() < (matrix.length*matrix[0].length)){
            // 1、先向右
            while (j < column){
                results.add(matrix[i][j]);
                j++;
            }
            //  2、再向下
            j--;
            i++;
            while (i < row){
                results.add(matrix[i][j]);
                i++;
            }
            i--;
            j--;
            //  3、再向左
            while ( j >= column1){
                results.add(matrix[i][j]);
                j--;
            }
            j = column1;
            i--;
            //  3、再向上
            while ( i > row1){
                results.add(matrix[i][j]);
                i--;
            }
            column--;
            row--;
            row1 ++;
            column1++;
            i = row1;
            j = column1;
        }
        int duo = results.size() - matrix.length*matrix[0].length;
        for (int k = 0; k < duo; k++) {
            results.remove(results.size()-1);
        }
        return results;
    }
}
