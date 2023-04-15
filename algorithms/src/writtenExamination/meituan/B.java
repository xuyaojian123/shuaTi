package writtenExamination.meituan;

import java.util.Scanner;

public class B {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int n =scanner.nextInt();
            int a = scanner.nextInt();
            int b =scanner.nextInt();
            int max = -10;
            for (int j = 1; j < n ; j++) {
                int p1 = j;
                int p2 = n-j;
                int t1 = a / p1;
                int t2 = b / p2;
                int t3 = Math.min(t1 ,t2);
                max = Math.max(t3,max);
            }
            System.out.println(max);
        }
    }
}
