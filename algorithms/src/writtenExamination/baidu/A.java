package writtenExamination.baidu;

import java.util.ArrayList;
import java.util.List;

public class A {

    public static void main(String[] args) {
        A a = new A();
        int[] b = {1,2,3,3};
        List<List<Integer>> lists = a.splitArray(b, 2);
        int t = 1;


    }

    public static List<List<Integer>> splitArray(int[] nums, int k) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
        List<List<Integer>> result = new ArrayList<>();
        int start = 0;
        while (start < n) {
            int end = binarySearch(nums, start, n, prefixSum[start] + (long) (prefixSum[n] - prefixSum[start]) / (k - result.size()));
            List<Integer> subList = new ArrayList<>();
            for (int i = start; i < end; i++) {
                subList.add(nums[i]);
            }
            result.add(subList);
            start = end;
        }
        return result;
    }

    private static int binarySearch(int[] nums, int start, int end, long target) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

}
