package writtenExamination.meituan;

import java.util.Arrays;
import java.util.Scanner;

// ���δ������
//���δ���ֵ���
//ʱ������:3000MS
//�ڴ�����:589824KB
//��Ŀ����:
//����һ��n����Ȼ��(�����ڵ���0������)�ļ���(�ɰ����ظ�Ԫ��]������Խ����������������:
//ѡ�񼯺��е�һ������x�������滻Ϊy��Ҫ��y>x
//�����������Сδ���ֵ���Ȼ��ΪK�����Ŀ���ǽ��������������ɴΣ�ʹ��K�����ֻ��Ҫ����������K���ɡ�
//��������
//��һ��һ��������n����ʾ�и�n��Ȼ��
//������һ������n����Ȼ��a1,a2...,an����ʾ�ü����ڵ���Ȼ����1��n��10e5 ��0<=ai<=n
//�������
//���һ�У�һ����������ʾ�𰸡�

//��������
//5
//5 0 0 2 2
//�������
// 4

//��ʾ
//���ڶ���Ԫ�غ͵��ĸ�Ԫ�طֱ��滻Ϊ1��3���������Ͼ��ǣ�5��1��0��3��2�����ĩ���ֵ�����4��

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
