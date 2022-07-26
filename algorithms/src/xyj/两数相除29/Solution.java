package xyj.两数相除29;

public class Solution {


    private long binarySearch(long a, long b) {
        if (a < b) {
            return 0;
        }
        long count = 1;
        int flag = 0;
        long temp = b;
        while (a > b) {
            count = count << 1;
            b = b << 1;
            flag = 1;
        }
        //回退一下
        if (flag == 1) {
            count = count >> 1;
            b = b >> 1;
        }
        return count + binarySearch(a - b, temp);
    }


    public int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        if (divisor == 1) return dividend;
        if (divisor == -1 && dividend==Integer.MIN_VALUE) return Integer.MAX_VALUE;
        if (divisor == -1) return -dividend;
        long a = dividend;
        long b = divisor;
        int sign = 1;
        if ((a > 0 && b < 0) || (a < 0 && b > 0)) {
            sign = -1;
        }
        a = a > 0 ? a : -a;
        b = b > 0 ? b : -b;
        long res = binarySearch(a, b);
        if (sign>0){
            if (res>Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }else {
                return (int) res;
            }
        }else {
            return (int) -res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int a = 10;
        int b = 3;
        int divide = solution.divide(a, b);
        System.out.println(divide);

    }
}
