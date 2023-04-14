package writtenExamination.腾讯音乐;

/**
 * @author 徐耀建
 * @date 2023/4/13 18:48
 * @Desc
 */
import java.util.*;

//小红的好数组
//小红定义一个数组为"好数组”，当且仅当该数组满足以下条件
//
//1.数组仅由0、1、2三种元素组成
//
//2.数组相邻的元素不相等。
//
//例如:121.2.0.1是好数组。小红定义一个数组的“陡峭值"”为该数组相邻元素的差的绝对值之和。
// 例如，[2,1,2,0,1]的陡峭值为|2-1|+|1-2|+|2-0|+|0-1| = 5.小红想知道，长度为n的所有好数组的陡峭值之和是多少? 由于答案过大，请对10^7取模，数据汇围:2<=n<=10^9
//数学题。找规律：
//
//n=2, f(n) = 8
//
//n=3, f(n) = 32
//
//n=4, f(n) = 96
//
//....
//
//f(n) = (n-1)*2^(n+1)
//
//但是n特别大，所以需要用到快速幂来计算。
public class A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int mod = (int)1e9 + 7;
        int ans = ((n-1) * fastMi(2, n + 1, mod)) % (mod);
        System.out.println(ans);
    }

    public static int fastMi(int x, int n, int m) {
        int res = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                res = (int)((long)res * x % m);
            }
            x = (int)((long)x * x % m);
            n /= 2;
        }
        return res;
    }
}