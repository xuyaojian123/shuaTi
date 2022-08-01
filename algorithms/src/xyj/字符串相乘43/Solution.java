package xyj.字符串相乘43;

// 大数相乘模板(https://blog.csdn.net/qq_43627087/article/details/99678529)
public class Solution {

    public String multiply(String num1, String num2) {
        int[] a = new int[200];
        int[] b = new int[200];
        int[] z = new int[405];
        int lenx = num1.length();
        int leny = num2.length();
        for (int i = lenx - 1,j=0; i >=0 ; i--) {
            a[j++] = num1.charAt(i) - '0';
        }
        for (int i = leny - 1,j=0; i >=0 ; i--) {
            b[j++] = num2.charAt(i) - '0';
        }
        for (int i = 0; i < lenx; i++) {
            for (int j = 0; j < leny; j++) {
                z[i+j] += a[i] * b[j];
            }
        }
        for (int i = 0; i < lenx + leny - 1; i++) {
            z[i+1]+=z[i]/10;
            z[i] = z[i]%10;
        }
        int ans = 0;
        for (int i = lenx + leny - 1; i >=0 ; i--) {
            if (z[i]!=0){
                ans = i;
                break;
            }
        }
        String result = "";
        for (int i = ans; i >=0 ; i--) {
            result = result + z[i];
        }
        return result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String num1 = "45675347864567534786456753478645675347864567534786456753478645675347864567534786456753478645675347864567534786456753478645675347864567534786456753478645675347864567534786456753478645675347864567534786";
        String num2 = "45675347864567534786456753478645675347864567534786456753478645675347864567534786456753478645675347864567534786456753478645675347864567534786456753478645675347864567534786456753478645675347864567534786";
        String multiply = solution.multiply(num1, num2);
        System.out.println(multiply);

    }
}
