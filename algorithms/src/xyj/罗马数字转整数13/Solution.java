package xyj.罗马数字转整数13;

public class Solution {

    private int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};


    public int romanToInt(String s) {
        int j = 0;
        int res = 0;
        for (int i = 0; i < this.symbols.length; i++) {
            String temp = symbols[i];
            int value = values[i];
            while (j<s.length()){
                if (j+temp.length() <= s.length() && temp.equals(s.substring(j,j+temp.length()))){
                    res+=value;
                    j+=temp.length();
                }else {
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int lviii = solution.romanToInt("DCXXI");
        System.out.println(lviii);

    }
}
