package xyj.P6342ÕÒ³öµþÍ¿ÔªËØ;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {2,8,7,4,1,3,5,6,9};
        int[][] mat = {{3,2,5},{1,4,6},{8,7,9}};
        int i = solution.firstCompleteIndex(arr, mat);
        System.out.println(i);

    }


    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Map<Integer, int[]> mapping = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mapping.put(mat[i][j],new int[]{i,j});
            }
        }
        int[] rows = new int[m];
        Arrays.fill(rows,n);
        int[] columns = new int[n];
        Arrays.fill(columns,mat.length);
        for (int i = 0; i < arr.length; i++) {
            int[] i_j = mapping.get(arr[i]);
            rows[i_j[0]] -= 1;
            columns[i_j[1]] -=1;
            if (rows[i_j[0]]==0 || columns[i_j[1]] ==0){
                return i;
            }
        }
        return 0;
    }


}
