package xyj.第N位数字400;

public class Solution {

    // 超时
    //public int findNthDigit(int n) {
    //    String str = "";
    //    for (int i = 1; i <= n; i++) {
    //        str += String.valueOf(i);
    //    }
    //    return Integer.valueOf(str.charAt(n-1) - '0');
    //
    //}

    public int findNthDigit(int n) {
        long i=1,j=9;
        long sum = i*j;
        // 第一步：判断n属于第几位数
        while (sum < n ){
            i++;
            j*=10;
            sum+=i*j;
        }
        // 第二步：判断n属于几位数的数字
        long ans = n - (sum - i*j)  - 1; //下标从零开始，0，10，100，1000，....
        long digit = (long)Math.pow(10,(i-1)) + ans/i ;
        // 第三步，属于这个数的第几位
        long position = ans%i;
        String str = String.valueOf(digit);
        return Integer.valueOf( str.charAt((int) position)-'0' );
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findNthDigit(10));
    }
}
