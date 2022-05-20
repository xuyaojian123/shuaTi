package xyj.电话号码的字母组合17;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public void dfs(int l,char[][] map,int n,char[] str,List<String> total){
        if( l == n){
            total.add(String.valueOf(str));
            return;
        }
        for (int i = 0; i < 4; i++) {
            if( map[l][i]!='#'){
                str[l] = map[l][i];
                dfs(l+1,map,n,str,total);
            }
        }

    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<String>();
        }

        int n = digits.length();
        char[][] map = new char[n][4];
        char[] chars = digits.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            map[i][3] = '#';
            int a = chars[i] - '0';
            if (a <= 6){
                map[i][0] = (char)('a' + (a-2)*3 + 0);
                map[i][1] = (char)('a' + (a-2)*3 + 1);
                map[i][2] = (char)('a' + (a-2)*3 + 2);
            }else if (a == 7){
                map[i][0] = 'p';
                map[i][1] = 'q';
                map[i][2] = 'r';
                map[i][3] = 's';
            }else if(a == 8){
                map[i][0] = 't';
                map[i][1] = 'u';
                map[i][2] = 'v';
            }else if(a == 9){
                map[i][0] = 'w';
                map[i][1] = 'x';
                map[i][2] = 'y';
                map[i][3] = 'z';
            }
        }
        for (int i = 0; i < map.length; i++) {
            System.out.println(map[i]);
        }
        char[] result = new char[n];
        List<String> total = new ArrayList<>();
        dfs(0,map,n,result,total);
        return total;
    }

    public static void main(String[] args) {
        String digits = "23";
        Solution solution = new Solution();
        solution.letterCombinations(digits);
    }
}
