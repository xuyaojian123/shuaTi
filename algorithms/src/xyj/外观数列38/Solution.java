package xyj.外观数列38;

import javafx.util.Pair;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public String countAndSay(int n) {
        String[] str = new String[31];
        str[1] = "1";str[2]="11";
        for (int i = 3; i <= 30; i++) {
            String s = str[i - 1];
            List<Integer> pos = new ArrayList<>();
            pos.add(0);
            String result = "";
            for (int j = 1; j < s.length(); j++) {
                if (s.charAt(j) != s.charAt(j-1)){
                    pos.add(j);
                }
            }
            pos.add(s.length());
            for (int j = 0; j < pos.size()-1; j++) {
                int num = s.substring(pos.get(j),pos.get(j+1)).length();
                result+= String.valueOf(num) + s.charAt(pos.get(j));
            }
            str[i] = result;
        }
        return str[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.countAndSay(10);
        System.out.println(s);

    }
}
