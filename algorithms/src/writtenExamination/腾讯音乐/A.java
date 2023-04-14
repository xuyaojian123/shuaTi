package writtenExamination.��Ѷ����;

/**
 * @author ��ҫ��
 * @date 2023/4/13 18:48
 * @Desc
 */
import java.util.*;

//С��ĺ�����
//С�춨��һ������Ϊ"�����顱�����ҽ���������������������
//
//1.�������0��1��2����Ԫ�����
//
//2.�������ڵ�Ԫ�ز���ȡ�
//
//����:121.2.0.1�Ǻ����顣С�춨��һ������ġ�����ֵ"��Ϊ����������Ԫ�صĲ�ľ���ֵ֮�͡�
// ���磬[2,1,2,0,1]�Ķ���ֵΪ|2-1|+|1-2|+|2-0|+|0-1| = 5.С����֪��������Ϊn�����к�����Ķ���ֵ֮���Ƕ���? ���ڴ𰸹������10^7ȡģ�����ݻ�Χ:2<=n<=10^9
//��ѧ�⡣�ҹ��ɣ�
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
//����n�ر��������Ҫ�õ������������㡣
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