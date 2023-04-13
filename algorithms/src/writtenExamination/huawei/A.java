package writtenExamination.huawei;

import java.util.Scanner;
//10
//-32 23 -93 -21 30 9 27 -88 93 61
//220
public class A {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=s.nextInt();
        }
        int ans=0;
        for(int num:nums){
            ans+=num;
        }
        int[] dpl=new int[n];
        int[] dpr=new int[n];
        int[] dp=new int[n];
        int min=nums[0];
        dpl[0]=0;
        dp[0]=nums[0];
        for(int i=1;i<n;i++){
            dp[i]=Math.min(dp[i-1]+nums[i],nums[i]);
            dpl[i]=min;
            min=Math.min(min,dp[i]);
        }
        min=nums[n-1];
        dp[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            dp[i]=Math.min(dp[i+1]+nums[i],nums[i]);
            dpr[i]=min;
            min=Math.min(min,dp[i]);
        }
        int t=ans;
        for(int i=0;i<n;i++){
            ans=Math.max(ans,t-dpl[i]-dpr[i]);
        }
        System.out.println(ans);
    }
}
