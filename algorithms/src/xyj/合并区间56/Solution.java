package xyj.合并区间56;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] a = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merge = solution.merge(a);

    }

    public int[][] merge(int[][] intervals) {
        int[] results = new int[10001];
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            for (int j = start; j <= end ; j++) {
                results[j] = 1;
            }
        }
        int i = 0;
        List<int[]> merged = new ArrayList<int[]>();
        while (i<results.length){
            if (results[i]==1){
                int[] inter = new int[2];
                inter[0] = i;
                while (results[i] == 1 && i < results.length){
                    i++;
                }
                inter[1] = i-1;
                merged.add(inter);
            }
            i++;
        }
        int[][] merged_interval = merged.toArray(new int[merged.size()][]);
        return merged_interval;
    }
}
