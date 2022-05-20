package xyj.括号生成22;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 递归-》看成是子集树 （没有用剪枝方法，没想到好办法剪枝）
public class Solution {

    public List<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<>();
        int[] x = new int[2*n];
        backtrack(x,0,2*n,result);
        return result;
    }

    public void backtrack (int[] x,int t,int n,List<String> result) {
        if (t == n) {
            if (checkAll(x)) {
                String str = "";
                for (int i = 0; i < n; i++) {
                    if (x[i] == 0) {
                        str += '(';
                    } else {
                        str += ')';
                    }
                }
                System.out.println(str);
                result.add(str);
            }
        } else {
            for (int i = 0; i <= 1; i++) {
                x[t] = i;
                backtrack(x, t + 1, n, result);
            }
        }
    }

    public Boolean checkAll(int[] x) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < x.length; i++) {
            if (x[i]==0){
                stack.push(0);
            }else if (x[i] == 1 && !stack.isEmpty()){
                stack.pop();
            }else {
                return false;
            }
        }
        if (stack.isEmpty()){
            return true;
        }else {
            return false;
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.generateParenthesis(3);
    }
}
