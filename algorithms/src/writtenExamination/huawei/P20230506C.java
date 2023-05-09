package writtenExamination.huawei;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class P20230506C {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int n = in.nextInt();
        //记录三种状态的地图
        int[][][] map = new int[3][n][n];

        int k = in.nextInt();
        for(int i = 0; i < k; i++) {
            int row = in.nextInt();
            int col = in.nextInt();
            map[0][row][col] = 1;
            map[1][row][col] = 1;
            map[2][row][col] = 1;
        }

        int gRow = in.nextInt();
        int gCol = in.nextInt();
        int wRow = in.nextInt();
        int wCol = in.nextInt();

        //后面加的不知道没过的5%是不是因为这个
        if(gRow == wRow && gCol == wCol) {
            System.out.println(0);
            return;
        }

        in.nextLine();
        for(int i = 0; i < n ;i++) {
            String[] str = in.nextLine().split(" ");
            for(int j = 0; j < n; j++) {
                if(str[j].charAt(0) == '1') map[0][i][j] = 1;
                if(str[j].charAt(1) == '1') map[1][i][j] = 1;
                if(str[j].charAt(2) == '1') map[2][i][j] = 1;
            }
        }

        //队列存储访问的位置
        LinkedList<int[]> positions = new LinkedList<>();
        int mapState = 0;
        int ans = 0;
        positions.addLast(new int[]{wRow, wCol});

        //存储访问过的状态
        HashSet<String> visited = new HashSet<>();
        String visitedStr = wRow + "," + wCol + "," + mapState;
        visited.add(visitedStr);

        //五种位移决策
        int[][] offsets = new int[][] {{0, 0}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}};


        while(!positions.isEmpty()) {
            int count = positions.size();
            mapState = (mapState + 1) % 3;
            int[][] m = map[mapState];
            ans++;
            for(int i = 0; i < count; i++) {
                int[] position = positions.pollFirst();
                for(int j = 0; j < offsets.length; j++) {
                    int[] newPosition = new int[]{position[0] + offsets[j][0], position[1] + offsets[j][1]};
                    if(newPosition[0] < 0 || newPosition[0] >= n || newPosition[1] < 0 || newPosition[1] >= n) continue;
                    if(m[newPosition[0]][newPosition[1]] == 1) continue;
                    visitedStr = newPosition[0] + "," + newPosition[1] + "," + mapState;
                    if(visited.contains(visitedStr)) continue;
                    visited.add(visitedStr);
                    if(newPosition[0] == gRow && newPosition[1] == gCol) {
                        System.out.println(ans);
                        return;
                    }
                    positions.addLast(newPosition);
                }
            }

        }

    }
}
