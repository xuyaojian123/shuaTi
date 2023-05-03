package xyj.P2662前往目标的最小代价;

import java.util.Arrays;

public class Solution {



    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = {1, 1};
        int[] ints1 = {4, 5};
        int[][] c = {{1,2,3,3,2},{3,4,4,5,1}};
        int i = solution.minimumCost(ints, ints1, c);
        System.out.println(i);

    }

    // 迪杰斯特拉求最短路径
    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        int n = specialRoads.length + 2;
        int[][] road = new int[n][5];
        road[0] = new int[]{start[0],start[1],start[0],start[1],0};
        int ans = 1;
        for (int[] specialRoad : specialRoads) {
            road[ans++] = specialRoad;
        }
        road[n-1] = new int[]{target[0],target[1],target[0],target[1],0};
        int[] dis = new int[n];
        boolean[] vis = new boolean[n];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[0] = 0;
        for (int i = 0; i < n; i++) {
            int minDist = Integer.MAX_VALUE;
            int u = -1;
            for (int j = 0; j < n; j++) {
                if (!vis[j] && dis[j] < minDist){
                    minDist = dis[j];
                    u = j;
                }
            }
            if (u==-1){
                break;
            }
            // 标记该节点为已经访问过
            vis[u] = true;
            for (int j = 0; j < n; j++) {
                if (vis[j]){
                    continue;
                }
                // 计算u到j的花费(u的终点到j的起点)
                int weight = Math.abs(road[u][2]-road[j][0]) + Math.abs(road[u][3]-road[j][1]);
                int alt = dis[u] + weight + Math.min(road[j][4],  Math.abs(road[j][0]-road[j][2]) + Math.abs(road[j][1]-road[j][3]));
                dis[j] = Math.min(dis[j], alt);
            }
        }
        return dis[n-1];
    }
}
