package ccf.归一化处理;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        double[] results = new double[n];
        double sum = 0;
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
            sum+=numbers[i];
        }
        double average = sum / n;
        double temp = 0;
        for (int i = 0; i < n; i++) {
            temp+=Math.pow((numbers[i]-average),2);
        }
        double std = Math.sqrt(temp / n);
        for (int i = 0; i < n; i++) {
            results[i] = (numbers[i] - average) / std;
            if (i!=0){
                System.out.println();
            }
            System.out.print(results[i]);
        }

    }
}
