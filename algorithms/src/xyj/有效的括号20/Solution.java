package xyj.��Ч������20;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// ʹ�ö�ջ���
public class Solution {

    public boolean isValid(String s) {
        boolean isValid = true;
        Stack<Character> symbol = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (symbol.isEmpty()){
                symbol.push(s.charAt(i));
            }else{
                if (s.charAt(i) == ')' && symbol.peek()=='('){
                    symbol.pop();
                }else if (s.charAt(i) == '}' && symbol.peek()=='{'){
                    symbol.pop();
                }else if(s.charAt(i) == ']' && symbol.peek()=='['){
                    symbol.pop();
                }else if (s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
                    symbol.push(s.charAt(i));
                }else {
                    isValid = false;
                    break;
                }
            }
        }
        if (!symbol.isEmpty()){
            isValid = false;
        }
        return isValid;

    }

    public static void main(String[] args) {

    }
}
