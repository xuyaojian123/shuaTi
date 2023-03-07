package ccf.—∞±¶¥Û√∞œ’;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int L = scanner.nextInt();
        int S = scanner.nextInt();
        int[][] A = new int[L + 1][L + 1];
        int[][] map = new int[S + 1][S + 1];
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            x.add(a);
            y.add(b);
            A[a][b] = 1;
        }
        for (int i = S; i >= 0; i--) {
            for (int j = 0; j < S+1; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
        int count = 0;
        for (int i = 0; i < x.size(); i++) {
            int a = x.get(i);
            int b = y.get(i);
            int isTure = 1;
            for (int j = 0; j < S+1; j++) {
                for (int k = 0; k < S+1; k++) {
                    if (a+j >L || b+k>L){
                        isTure = 0;
                        break;
                    }
                    if (A[a+j][b+k] != map[j][k]){
                        isTure = 0;
                        break;
                    }
                }
            }
            if (isTure == 1){
                count++;
            }
        }
        System.out.println(count);

    }
}
