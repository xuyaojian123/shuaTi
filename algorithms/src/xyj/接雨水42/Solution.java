package xyj.����ˮ42;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {

    //��̬�滮
    public int trap2(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; ++i) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }


    // ����ջ��� ( Ҫ����ʢˮ�������м�ͣ����߸� )
    public int trap(int[] height) {
        int sum = 0;
        int i = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        while (i < height.length){
            if (stack.isEmpty() ){
                stack.push(i);
                i++;
            }else if (stack.size() == 1){
                int last = stack.peek();
                if ( height[i] > height[last] ) {
                    stack.pop();
                }
                stack.push(i);
                i++;
            }else {
                int last = stack.peek();
                if ( height[i] <= height[last]){
                    stack.push(i);
                    i++;
                }else {
                    int pop = stack.pop();
                    int peek = stack.peek();
                    int width = i - peek - 1;
                    int hei= Math.min(height[i],height[peek]) - height[pop];
                    sum += (width*hei);
                }
            }
        }
        return sum;
    }




    // ������뷨�Ǵ���ģ�ӦΪ���ܺ���ĸ߶ȿ��Ժ�֮ǰ�ĸ߶��γ�������ʢˮ
    public int trap1(int[] height) {
        int sum = 0;
        int k = 0;
        while (height[k]==0){
            k++;
        }
        while (true){
            int temp = 0 ,flag =0;
            // �������ߣ� ��һ���� ����͵�
            int low = k;
            while (low+1 < height.length && height[low]>= height[low+1]){
                low++;
            }
            int up = low;
            // �ڶ���������ߵ�
            while (up+1 < height.length && height[up] <= height[up+1]){
                flag=1;
                up++;
            }
            // ����ʢˮ���
            int width = (up - k) - 1;
            if (flag ==0){
                break;
            }
            int hei = Math.min(height[k],height[up]);
            for (int j = k+1; j < up; j++) {
                if ( height[j] > hei){
                    temp+=hei;
                }else {
                    temp+=height[j];
                }
            }
            sum += (width*hei) - temp;
            k = up;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = {4,2,0,3,2,5};
        //int[] ints = {0,1,0,2,1,0,1,3,2,1,2,1};
        int trap = solution.trap(ints);
        System.out.println(trap);

    }
}
