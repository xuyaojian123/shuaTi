package xyj.整数转罗马数字12;

public class Solution {

    public String intToRoman(int num) {
        String res = "";
        int a = num / 1000;
        for (int i = 0; i < a; i++) {
            res+="M";
        }
        num = num - 1000*a;
        if (num >= 900){
            res+="CM";
            num = num -900;
        }else if (num >= 500 ){
            res+="D";
            num = num - 500;
        }else if (num>=400 && num<500){
            res+="CD";
            num = num - 400;
        }
        int b = num/100;
        for (int i = 0; i < b; i++) {
            res+="C";
        }
        num = num - 100*b;
        if (num >= 90){
            res+="XC";
            num = num -90;
        }else if (num >= 50 ){
            res+="L";
            num = num - 50;
        }else if (num>=40 && num<50){
            res+="XL";
            num = num - 40;
        }
        int c = num/10;
        for (int i = 0; i < c; i++) {
            res+="X";
        }
        num = num - 10*c;

        if (num >= 9){
            res+="IX";
            num = num -9;
        }else if (num >= 5 ){
            res+="V";
            num = num - 5;
        }else if (num>=4 && num<5){
            res+="IV";
            num = num - 4;
        }
        int d = num/1;
        for (int i = 0; i < d; i++) {
            res+="I";
        }
        return res;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.intToRoman(10);
        System.out.println(s);
    }
}
