package xyj.P2685统计完全连通分量的数量;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] edges = {{0, 1},{0, 2},{1, 2},{3, 4}};
        int n = 6;
        int i = solution.countCompleteComponents(n, edges);
        System.out.println(i);
    }

    int n = 50;
    int[] parents = new int[n];

    // 并查集
    public void init(){
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
    }

    public int find_root(int x){
        if (parents[x]!=x){
            parents[x] = find_root(parents[x]);// 这行代码进行路径压缩
        }
        return parents[x];
    }

    public int find_root1(int x){
        while (parents[x]!=x){
            parents[x] = parents[parents[x]];// 这行代码进行路径压缩
            x = parents[x];
        }
        return x;
    }

    public void union(int a, int b){
        int x = find_root(a);
        int y = find_root(b);
        if (x!=y){
            parents[x] = y;//将x接到y上
        }
    }

    public int countCompleteComponents1(int n, int[][] edges) {
        init();
        for (int i = 0; i < edges.length; i++) {
            union(edges[i][0],edges[i][1]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (parents[i] == i){
                ans++;
            }
        }
        return ans;
    }


    private int e = 0;
    private int v = 0;
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        int[] vis = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (vis[i]==0){
                dfs(i,graph,vis);
                if (e == (v*(v-1))){
                    ans++;
                }
                e = 0;
                v = 0;
            }
        }
        return ans;
    }

    public void dfs(int i, List<List<Integer>> graph, int[] vis){
        int edges_num = graph.get(i).size();
        v++;
        e+= edges_num;
        vis[i] = 1;
        for (int j = 0; j < graph.get(i).size(); j++) {
            int node = graph.get(i).get(j);
            if (vis[node]==0){
                dfs(node,graph,vis);
            }
        }
    }



}
