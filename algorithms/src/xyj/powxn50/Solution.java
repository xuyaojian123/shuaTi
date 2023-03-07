package xyj.powxn50;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {


    }

    //方法二：快速幂 + 迭代(二进制做法，n转换为二进制。77（1001101)
    public double quickPow1(double x, int n){
        double start = x;
        double res = 1.0;
        long N = n;
        if (n<0){
            N = -n;
        }
        while (N>0){
            if (N%2==1){
                res = res*start;
            }
            start = start*start;
            N = N /2;
        }
        return (n>0)? res: 1.0/res;
    }

    //方法一：快速幂 + 递归(77->38->19->9->4->2->1)
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;


    }

}
