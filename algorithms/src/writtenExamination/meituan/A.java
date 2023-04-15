package writtenExamination.meituan;

import java.util.Scanner;

public class A {
    public static void solve() {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();
        int m = str1.length();
        int n = str2.length();
        if (m == 0) {
            System.out.println(0);
            return;
        } else if (n == 0) {
            System.out.println(m);
            return;
        }
        int i = 0, j = 0, ans = 0;
        while (i < m && j < n) {
            if (str1.charAt(i++) == str2.charAt(j++)) {
                continue;
            }
            ans++;
        }
        ans += (i >= m) ? 0 : m - i;
        System.out.println(ans);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-- > 0) {
            solve();
        }
    }
}
