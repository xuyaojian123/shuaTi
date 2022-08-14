package xyj.通配符匹配44;

public class Main {
    private Boolean[][] vis;

    public boolean isMatch(String s, String p) {
        // 带备忘录的递归
        vis = new Boolean[s.length()][p.length()];
        boolean dfs = dfs(s, p, 0, 0);
        return dfs;

    }

    public boolean dfs(String s,String p,int a,int b){
        // 结束条件1 p字符串末尾（包含了p为空字符串的情况）
        if (b == p.length()){
            return a == s.length();
        }
        //结束条件2 s字符串末尾(包含了s为空字符串的情况)
        if (a == s.length()){
            for (int i = b; i < p.length(); i++) {
                if (p.charAt(i)!='*'){
                    return false;
                }
            }
            return true;
        }
        if (vis[a][b]!=null){
            return vis[a][b];
        }
        boolean res = false;
        char x = s.charAt(a);
        char y = p.charAt(b);
        if (y =='?'){
            return dfs(s,p,a+1,b+1);
        }else if (y !='*'){
           if (x!=y){
               res = false;
           }else {
               res = dfs(s,p,a+1,b+1);
           }
        }else {
            // 遇到*号字符 可以选择匹配0次或者一次
            res = dfs(s,p,a,b+1) || dfs(s,p,a+1,b);
        }
        vis[a][b] = res;
        return res;
    }


    public static void main(String[] args) {
        Main main = new Main();
        String s = "acdcb";
        String p = "a*c?b";
        boolean match = main.isMatch(s, p);
        System.out.println(match);

    }
}
