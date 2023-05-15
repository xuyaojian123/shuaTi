package xyj.P6430找出转圈游戏输家;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

    }

    public int[] circularGameLosers(int n, int k) {
        int start = 1;
        int pos = 0;
        int[] flags = new int[n];
        flags[0] = 1;
        while (true){
            int index = (pos + start*k)%n;
            if (flags[index]==1){
                break;
            }
            flags[index] = 1;
            start++;
            pos = index;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (flags[i]==0){
                result.add(i+1);
            }
        }
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }
}
