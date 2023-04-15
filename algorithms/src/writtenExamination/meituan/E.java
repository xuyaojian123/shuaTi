package writtenExamination.meituan;

import java.util.Arrays;
import java.util.Scanner;

// 最大未出现数
//最大未出现的数
//时间限制:3000MS
//内存限制:589824KB
//题目描述:
//你有一个n个自然数(即大于等于0的整数)的集合(可包含重复元素]，你可以进行如下任意次提作:
//选择集合中的一个数字x，将其替换为y，要求y>x
//设这个集合最小未出现的自然数为K，你的目标是进行上述操作若干次，使得K最大。你只需要输出这个最大的K即可。
//输入描述
//第一行一个正整数n，表示有个n自然数
//接下来一行输入n个自然数a1,a2...,an，表示该集合内的自然数。1《n《10e5 ，0<=ai<=n
//输出描述
//输出一行，一个整数，表示答案。

//样例输入
//5
//5 0 0 2 2
//样例输出
// 4

//提示
//将第二个元素和第四个元素分别替换为1和3，这样集合就是（5，1，0，3，2）最大末出现的数是4。

public class E {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = scanner.nextInt();
        }
        Arrays.sort(ans);
        for (int i = 0; i < n; i++) {
            if (ans[i] > i){
                System.out.println(i);
                break;
            }
        }

    }
}
