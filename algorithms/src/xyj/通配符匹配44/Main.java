package xyj.ͨ���ƥ��44;

public class Main {
    private Boolean[][] vis;

    public boolean isMatch(String s, String p) {
        // ������¼�ĵݹ�
        vis = new Boolean[s.length()][p.length()];
        boolean dfs = dfs(s, p, 0, 0);
        return dfs;

    }

    public boolean dfs(String s,String p,int a,int b){
        // ��������1 p�ַ���ĩβ��������pΪ���ַ����������
        if (b == p.length()){
            return a == s.length();
        }
        //��������2 s�ַ���ĩβ(������sΪ���ַ��������)
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
            // ����*���ַ� ����ѡ��ƥ��0�λ���һ��
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
