package dp;

import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 9;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(fibonacci(n, dp));
        System.out.println(tabulation(n));
        System.out.println(spaceOptimized(n));
    }

    private static int spaceOptimized(int n) {
        int prev = 1;
        int prev2 = 0;
        int currI = 0;
        for(int i = 2; i<=n; i++){
            currI = prev2 + prev;
            prev2 = prev;
            prev = currI;
        }
        return currI;

    }

    private static int tabulation(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    private static int fibonacci(int n, int[] dp) {
        if(n <= 1){
            return n;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        dp[n] =  fibonacci(n-1, dp) + fibonacci(n-2, dp);
        return dp[n];
    }
}
