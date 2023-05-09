package writtenExamination.huawei;

import java.util.Scanner;

//14
//0xE77F

//2
//+2
//01100010000000
//-2
//00000110001000

//18
//0x677F 0xFFFF

//1
//-2
//001001100010000000
public class P20230506 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String line = scanner.nextLine();
        String[] s = line.split(" ");
        String res = "";
        for (int i = 0; i < s.length; i++) {
            String s1 = s[i];
            s1 = s1.substring(2,s1.length());
            int value = Integer.parseInt(s1, 16);
            String s2 = Integer.toBinaryString(value);
            int len = s2.length();
            for (int j = 0; j < 16 - len; j++) {
                s2 = "0" + s2;
            }
            res = res + s2;
            if (res.length()>=n){
                break;
            }
        }
        res = res.substring(0,n);
        int sum1 = 0;
        int zheng = 0;
        String a1="",a2="";
        for (int i = 0; i < n/2; i++) {
            String a = res.substring(i);
            String c = res.substring(0,i);
            String b = res.substring(0, res.length());
            StringBuilder temp = new StringBuilder();
            int ans = 0;
            for (int j = 0; j < c.length(); j++) {
                if (c.charAt(j)=='0'){
                    ans = 2;
                    break;
                }
            }
            if (ans==2){
                break;
            }
            for (int j = 0; j < a.length(); j++) {
                if (a.charAt(j)=='0' && b.charAt(j)=='0'){
                    ans = 1;
                    break;
                }else if (a.charAt(j)=='1' && b.charAt(j)=='1'){
                    temp.append("0");
                }else if (a.charAt(j)=='0' && b.charAt(j)=='1'){
                    temp.append("1");
                }else if (a.charAt(j)=='1' && b.charAt(j)=='0'){
                    temp.append("0");
                }else {
                    System.out.println("´íÎó");
                }
            }
            if (ans == 0){
                if (i == 0){
                    break;
                }
                sum1++;
                zheng = i;
                String s1 = temp.toString();
                int length = s1.length();
                for (int j = 0; j < n - length; j++) {
                    s1 += "0";
                }
                a1 = s1;
                break;
            }
        }

        int sum2 = 0;
        int fu = 0;
        for (int i = 0; i <= (n/2); i++) {
            String a = res.substring(0,res.length());
            String b = res.substring(i, res.length());
            String c = res.substring(b.length(), res.length());
            StringBuilder temp = new StringBuilder();
            int ans = 0;
            for (int j = 0; j < c.length(); j++) {
                if (c.charAt(j)=='0'){
                    ans = 2;
                    break;
                }
            }
            if (ans==2){
                break;
            }
            for (int j = 0; j < b.length(); j++) {
                if (a.charAt(j)=='0' && b.charAt(j)=='0'){
                    ans = 1;
                    break;
                }else if (a.charAt(j)=='1' && b.charAt(j)=='1'){
                    temp.append("0");
                }else if (a.charAt(j)=='0' && b.charAt(j)=='1'){
                    temp.append("1");
                }else if (a.charAt(j)=='1' && b.charAt(j)=='0'){
                    temp.append("0");
                }else {
                    System.out.println("´íÎó");
                }
            }
            if (ans == 0){
                if (i == 0){
                    break;
                }
                sum2++;
                fu = i;
                String s1 = temp.toString();
                int length = s1.length();
                for (int j = 0; j < n - length; j++) {
                    s1 = "0" + s1;
                }
                a2 = s1;
                break;
            }
        }
        System.out.println(sum1+sum2);
        if (sum1==1){
            System.out.println("+"+zheng);
            System.out.println(a1);
        }
        if (sum2==1){
            System.out.println("-"+fu);
            System.out.println(a2);
        }
    }
}
