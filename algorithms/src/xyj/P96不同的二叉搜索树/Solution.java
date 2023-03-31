package xyj.P96��ͬ�Ķ���������;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.numTrees(3);
        System.out.println(i);

    }

    // ��������Catalan�������ѧ���������
    //https://leetcode.cn/problems/unique-binary-search-trees/solution/hua-jie-suan-fa-96-bu-tong-de-er-cha-sou-suo-shu-b/
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                G[i] += (G[j]*G[i-j-1]);
            }
        }
        return G[n];
    }
}
