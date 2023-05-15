package xyj.P6431相邻值的按位异或;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

    }


    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;
        int[] original = new int[n];
        for (int i = 1; i < n; i++) {
            original[i] = original[i-1] ^ derived[i-1];
        }
        if ((original[0] ^ original[n-1])!=derived[n-1]){
            return false;
        }
        return true;
    }
}
