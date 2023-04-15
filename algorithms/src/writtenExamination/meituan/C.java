package writtenExamination.meituan;

import java.util.HashMap;
import java.util.Scanner;

public class C {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //HashMap<String, Integer> road = new HashMap<>();

        int n = scanner.nextInt();
        int T = scanner.nextInt();

        int[] road = new int[n+1];//road[i]表示城市i到i+1有一条路
        for (int i = 0; i < T; i++) {
            String key = scanner.next();
            int pos = scanner.nextInt();
            if (key.equals("L")){
                if (pos>1){
                    road[pos-1] = 1;
                }
            }else if (key.equals("R")){
                if (pos<n){
                    road[pos] = 1;
                }
            }else {
                // 往左
                int left = pos;
                while (road[left-1]==1){
                    left--;
                }
                // 往右
                int right = pos;
                while (road[right]==1){
                    right++;
                }
                System.out.println(left + " " + right);
            }
        }
    }
}
//3 5
//Q 2
//L 2
//Q 2
//R 2
//Q 2

//2 2
//1 2
//1 3